// Generated from PR1.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PR1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PR1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PR1Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(PR1Parser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PR1Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(PR1Parser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PR1Parser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PR1Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(PR1Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#ifState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfState(PR1Parser.IfStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#whileState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileState(PR1Parser.WhileStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#breakState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakState(PR1Parser.BreakStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#continueState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueState(PR1Parser.ContinueStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PR1Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#writeState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteState(PR1Parser.WriteStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#readState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadState(PR1Parser.ReadStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PR1Parser#returnState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnState(PR1Parser.ReturnStateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PR1Parser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(PR1Parser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(PR1Parser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(PR1Parser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(PR1Parser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(PR1Parser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(PR1Parser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(PR1Parser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(PR1Parser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(PR1Parser.BoolFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(PR1Parser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(PR1Parser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(PR1Parser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(PR1Parser.BoolTrueContext ctx);
}