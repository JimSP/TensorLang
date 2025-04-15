package lang;

import lang.parser.TensorLangBaseVisitor;
import lang.parser.TensorLangParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;

public class TensorLangInterpreter extends TensorLangBaseVisitor<Object> {

    private final Deque<Env> envStack = new ArrayDeque<>();

    public TensorLangInterpreter() {
        envStack.push(new Env());
        loadBuiltins();
    }

    private void loadBuiltins() {
        Env global = envStack.peek();
        // Operador de adição
        global.set("+", (TensorFunction) (args, interp) -> {
            if (args.size() != 2)
                throw new RuntimeException("Operador '+' espera 2 argumentos");
            Tensor a = (Tensor) args.get(0);
            Tensor b = (Tensor) args.get(1);
            return a.add(b);
        });
        // Operador de subtração
        global.set("-", (TensorFunction) (args, interp) -> {
            if (args.size() != 2)
                throw new RuntimeException("Operador '-' espera 2 argumentos");
            Tensor a = (Tensor) args.get(0);
            Tensor b = (Tensor) args.get(1);
            return a.sub(b);
        });
        // Operador lógico AND
        global.set("&&", (TensorFunction) (args, interp) -> {
            if (args.size() != 2)
                throw new RuntimeException("Operador '&&' espera 2 argumentos");
            Tensor a = (Tensor) args.get(0);
            Tensor b = (Tensor) args.get(1);
            int maxLength = Math.max(a.length(), b.length());
            double[] result = new double[maxLength];
            for (int i = 0; i < maxLength; i++) {
                double aval = (i < a.length()) ? a.getData()[i] : a.getData()[0];
                double bval = (i < b.length()) ? b.getData()[i] : b.getData()[0];
                result[i] = (aval != 0 && bval != 0) ? 1.0 : 0.0;
            }
            return new Tensor(result);
        });
        // Operador lógico OR
        global.set("||", (TensorFunction) (args, interp) -> {
            if (args.size() != 2)
                throw new RuntimeException("Operador '||' espera 2 argumentos");
            Tensor a = (Tensor) args.get(0);
            Tensor b = (Tensor) args.get(1);
            int maxLength = Math.max(a.length(), b.length());
            double[] result = new double[maxLength];
            for (int i = 0; i < maxLength; i++) {
                double aval = (i < a.length()) ? a.getData()[i] : a.getData()[0];
                double bval = (i < b.length()) ? b.getData()[i] : b.getData()[0];
                result[i] = (aval != 0 || bval != 0) ? 1.0 : 0.0;
            }
            return new Tensor(result);
        });
    }

    public void pushScope(Env env) {
        envStack.push(env);
    }

    public void popScope() {
        envStack.pop();
    }

    public void setVar(String name, Object value) {
        envStack.peek().set(name, value);
    }

    public Object getVar(String name) {
        for (Env env : envStack) {
            Object val = env.get(name);
            if (val != null)
                return val;
        }
        return null;
    }

    @Override
    public Object visitProgram(TensorLangParser.ProgramContext ctx) {
        Object result = null;
        for (TensorLangParser.StatementContext stmt : ctx.statement()) {
            result = visit(stmt);
        }
        return result;
    }

    @Override
    public Object visitAssign(TensorLangParser.AssignContext ctx) {
        String varName = ctx.ID().getText();
        Object value = visit(ctx.expr());
        setVar(varName, value);
        return value;
    }

    @Override
    public Object visitPrint(TensorLangParser.PrintContext ctx) {
        Object value = visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    @Override
    public Object visitVarExpr(TensorLangParser.VarExprContext ctx) {
        String varName = ctx.ID().getText();
        Object value = getVar(varName);
        if (value == null)
            throw new RuntimeException("Variável não definida: " + varName);
        return value;
    }

    @Override
    public Object visitNumberLiteral(TensorLangParser.NumberLiteralContext ctx) {
        double num = Double.parseDouble(ctx.NUMBER().getText());
        return new Tensor(new double[] { num });
    }

    @Override
    public Object visitStringLiteral(TensorLangParser.StringLiteralContext ctx) {
        String s = ctx.STRING().getText();
        s = s.substring(1, s.length() - 1);
        double[] codes = s.chars().asDoubleStream().toArray();
        return new Tensor(codes);
    }

    @Override
    public Object visitBoolLiteral(TensorLangParser.BoolLiteralContext ctx) {
        boolean b = ctx.BOOL().getText().equals("true");
        double val = b ? 1.0 : 0.0;
        return new Tensor(new double[] { val });
    }

    @Override
    public Object visitCharLiteral(TensorLangParser.CharLiteralContext ctx) {
        String s = ctx.CHAR().getText();
        double code = s.charAt(0);
        return new Tensor(new double[] { code });
    }

    @Override
    public Object visitVectorLiteral(TensorLangParser.VectorLiteralContext ctx) {
        List<Tensor> elements = new ArrayList<>();
        if (ctx.exprList() != null) {
            for (TensorLangParser.ExprContext expr : ctx.exprList().expr()) {
                Object val = visit(expr);
                if (val instanceof Tensor) {
                    elements.add((Tensor) val);
                } else {
                    throw new RuntimeException("Elementos de vetor devem ser tensores");
                }
            }
        }
        List<Double> list = new ArrayList<>();
        for (Tensor t : elements) {
            for (double d : t.getData()) {
                list.add(d);
            }
        }
        double[] array = list.stream().mapToDouble(Double::doubleValue).toArray();
        return new Tensor(array);
    }

    @Override
    public Object visitBinaryOp(TensorLangParser.BinaryOpContext ctx) {
        Object left = visit(ctx.binaryExpr(0));
        Object right = visit(ctx.binaryExpr(1));
        String op = ctx.op.getText();
        Object func = getVar(op);
        if (func == null || !(func instanceof TensorFunction))
            throw new RuntimeException("Operador " + op + " não definido como função");
        TensorFunction tf = (TensorFunction) func;
        return tf.apply(Arrays.asList(left, right), this);
    }

    @Override
    public Object visitUnaryNeg(TensorLangParser.UnaryNegContext ctx) {
        Object val = visit(ctx.expr());
        Object zero = new Tensor(new double[] { 0.0 });
        Object minus = getVar("-");
        if (minus == null || !(minus instanceof TensorFunction))
            throw new RuntimeException("Operador '-' não definido para negação unária");
        TensorFunction negFunc = (TensorFunction) minus;
        return negFunc.apply(Arrays.asList(zero, val), this);
    }

    @Override
    public Object visitFunctionDef(TensorLangParser.FunctionDefContext ctx) {
        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (TerminalNode id : ctx.paramList().ID()) {
                params.add(id.getText());
            }
        }
        Env closure = envStack.peek().copy();
        return new UserFunction(params, ctx.expr(), closure);
    }

    @Override
    public Object visitFunctionCall(TensorLangParser.FunctionCallContext ctx) {
        Object func = visit(ctx.primaryExpr());
        for (TensorLangParser.ArgListContext argListCtx : ctx.argList()) {
            List<Object> args = new ArrayList<>();
            if (argListCtx != null) {
                for (TensorLangParser.ExprContext arg : argListCtx.expr()) {
                    args.add(visit(arg));
                }
            }
            if (!(func instanceof TensorFunction))
                throw new RuntimeException("Tentativa de chamar um valor não-função: " + func);
            func = ((TensorFunction) func).apply(args, this);
        }
        return func;
    }

    @Override
    public Object visitParens(TensorLangParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitLiteralExpr(TensorLangParser.LiteralExprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Object visitExprBinary(TensorLangParser.ExprBinaryContext ctx) {
        return visit(ctx.binaryExpr());
    }

    @Override
    public Object visitExprApply(TensorLangParser.ExprApplyContext ctx) {
        return visit(ctx.applyExpr());
    }
}
