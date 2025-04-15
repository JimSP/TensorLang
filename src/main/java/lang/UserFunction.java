package lang;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.List;

public class UserFunction implements TensorFunction {
    private final List<String> params;
    private final ParseTree body;
    private final Env closure;

    public UserFunction(List<String> params, ParseTree body, Env closure) {
        this.params = params;
        this.body = body;
        this.closure = closure;
    }

    @Override
    public Object apply(List<Object> args, TensorLangInterpreter interpreter) {
        // Cria novo escopo a partir da closure capturada
        interpreter.pushScope(closure.copy());
        try {
            for (int i = 0; i < params.size(); i++) {
                Object value = (i < args.size()) ? args.get(i) : null;
                interpreter.setVar(params.get(i), value);
            }
            Object result = interpreter.visit(body);
            return result;
        } finally {
            interpreter.popScope();
        }
    }
}
