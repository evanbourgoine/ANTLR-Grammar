// Generated from PR1.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PR1Parser}.
 */
public interface PR1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PR1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PR1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PR1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PR1Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PR1Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(PR1Parser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(PR1Parser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(PR1Parser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(PR1Parser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PR1Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PR1Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PR1Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PR1Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#ifState}.
	 * @param ctx the parse tree
	 */
	void enterIfState(PR1Parser.IfStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#ifState}.
	 * @param ctx the parse tree
	 */
	void exitIfState(PR1Parser.IfStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#whileState}.
	 * @param ctx the parse tree
	 */
	void enterWhileState(PR1Parser.WhileStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#whileState}.
	 * @param ctx the parse tree
	 */
	void exitWhileState(PR1Parser.WhileStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#breakState}.
	 * @param ctx the parse tree
	 */
	void enterBreakState(PR1Parser.BreakStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#breakState}.
	 * @param ctx the parse tree
	 */
	void exitBreakState(PR1Parser.BreakStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#continueState}.
	 * @param ctx the parse tree
	 */
	void enterContinueState(PR1Parser.ContinueStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#continueState}.
	 * @param ctx the parse tree
	 */
	void exitContinueState(PR1Parser.ContinueStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PR1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PR1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#writeState}.
	 * @param ctx the parse tree
	 */
	void enterWriteState(PR1Parser.WriteStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#writeState}.
	 * @param ctx the parse tree
	 */
	void exitWriteState(PR1Parser.WriteStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#readState}.
	 * @param ctx the parse tree
	 */
	void enterReadState(PR1Parser.ReadStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#readState}.
	 * @param ctx the parse tree
	 */
	void exitReadState(PR1Parser.ReadStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PR1Parser#returnState}.
	 * @param ctx the parse tree
	 */
	void enterReturnState(PR1Parser.ReturnStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PR1Parser#returnState}.
	 * @param ctx the parse tree
	 */
	void exitReturnState(PR1Parser.ReturnStateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PR1Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PR1Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(PR1Parser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(PR1Parser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(PR1Parser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(PR1Parser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(PR1Parser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(PR1Parser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational(PR1Parser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational(PR1Parser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(PR1Parser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(PR1Parser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical(PR1Parser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical(PR1Parser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(PR1Parser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(PR1Parser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PR1Parser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PR1Parser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(PR1Parser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(PR1Parser.BoolFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(PR1Parser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(PR1Parser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(PR1Parser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(PR1Parser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(PR1Parser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(PR1Parser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(PR1Parser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PR1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(PR1Parser.BoolTrueContext ctx);
}