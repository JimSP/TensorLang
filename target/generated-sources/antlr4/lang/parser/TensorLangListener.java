// Generated from TensorLang.g4 by ANTLR 4.13.1
package lang.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TensorLangParser}.
 */
public interface TensorLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TensorLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TensorLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TensorLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TensorLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(TensorLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(TensorLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TensorLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TensorLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryNeg}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryNeg(TensorLangParser.UnaryNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryNeg}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryNeg(TensorLangParser.UnaryNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFn}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFn(TensorLangParser.ExprFnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFn}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFn(TensorLangParser.ExprFnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDef}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(TensorLangParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDef}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(TensorLangParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBinary}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 */
	void enterExprBinary(TensorLangParser.ExprBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBinary}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 */
	void exitExprBinary(TensorLangParser.ExprBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprApply}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterExprApply(TensorLangParser.ExprApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprApply}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitExprApply(TensorLangParser.ExprApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(TensorLangParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(TensorLangParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TensorLangParser#applyExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(TensorLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TensorLangParser#applyExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(TensorLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterParens(TensorLangParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitParens(TensorLangParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(TensorLangParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(TensorLangParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(TensorLangParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(TensorLangParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(TensorLangParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(TensorLangParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(TensorLangParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(TensorLangParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(TensorLangParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(TensorLangParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(TensorLangParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(TensorLangParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterVectorLiteral(TensorLangParser.VectorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitVectorLiteral(TensorLangParser.VectorLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(TensorLangParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(TensorLangParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(TensorLangParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(TensorLangParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TensorLangParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(TensorLangParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TensorLangParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(TensorLangParser.ArgListContext ctx);
}