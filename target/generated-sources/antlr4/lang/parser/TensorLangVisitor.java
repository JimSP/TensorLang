// Generated from TensorLang.g4 by ANTLR 4.13.1
package lang.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TensorLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TensorLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TensorLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TensorLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(TensorLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TensorLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryNeg}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryNeg(TensorLangParser.UnaryNegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFn}
	 * labeled alternative in {@link TensorLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFn(TensorLangParser.ExprFnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDef}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(TensorLangParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBinary}
	 * labeled alternative in {@link TensorLangParser#fnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinary(TensorLangParser.ExprBinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprApply}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprApply(TensorLangParser.ExprApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TensorLangParser#binaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(TensorLangParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link TensorLangParser#applyExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(TensorLangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(TensorLangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(TensorLangParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link TensorLangParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(TensorLangParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(TensorLangParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(TensorLangParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(TensorLangParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(TensorLangParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorLiteral}
	 * labeled alternative in {@link TensorLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorLiteral(TensorLangParser.VectorLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(TensorLangParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(TensorLangParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TensorLangParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(TensorLangParser.ArgListContext ctx);
}