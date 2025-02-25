import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Evan Bourgoine
 * CS3304 Project 1: Full Visitor File
 */
public class PR1FullVisitor extends PR1BaseVisitor<Object> {
    
    //map to store variable values
    private Map<String, Object> memory = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Function> functions = new HashMap<>();
    private Stack<Map<String, Object>> scopes = new Stack<>();

    //creates global scope (used in main method)
    public void initializeGlobalScope() {
        scopes.push(new HashMap<>());
    }
    
    //function helper class
    private class Function {
        List<String> params;
        PR1Parser.BlockContext body;

        Function(List<String> params, PR1Parser.BlockContext body) {
            this.params = params;
            this.body = body;
        }
    }

    
    //returns the value of the id
    private Object getValue(String idValue) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, Object> scope = scopes.get(i);
            if (scope.containsKey(idValue)) {
                return scope.get(idValue);
            }
        }
        System.err.println("Error: Variable " + idValue + " is undefined.");
        return UNDEFINED;
    }

    private static class ReturnValue extends RuntimeException {
        private final Object value;
        public ReturnValue(Object value) { this.value = value; }
        public Object getValue() { return value; }
    }

    //-----------------
    // Break
    //---------------
    private static class BreakException extends RuntimeException {}

    //-----------------------
    // Continue
    //--------------
    private static class ContinueException extends RuntimeException {}

    //-------------------------
    // Visit Function Declaration
    //---------------------------
    @Override
    public Object visitFunctionDecl(PR1Parser.FunctionDeclContext funDec) {

        //get function name
        String functionName = funDec.ID(0).getText(); 
        List<String> params = new ArrayList<>();

        //add the parameters for the id
        for (int i = 1; i < funDec.ID().size(); i++) {
            params.add(funDec.ID(i).getText());
        }

        functions.put(functionName, new Function(params, funDec.block()));
        return null;
    }

    //------------------------
    // Visit Function Call
    //----------------------
    @Override
    public Object visitFunctionCall(PR1Parser.FunctionCallContext funCall) {
        String functionName = funCall.ID().getText();
        Function function = functions.get(functionName);

        if (function == null) {
            throw new RuntimeException("Error: Undefined function " + functionName);
        }

        // Evaluate arguments and map them to function parameters in the local scope
        Map<String, Object> localScope = new HashMap<>();
        for (int i = 0; i < funCall.expression().size(); i++) {
            localScope.put(function.params.get(i), visit(funCall.expression(i)));
        }

        // Push the new scope onto the stack
        scopes.push(localScope);

        Object result = null;
        try {
            visit(function.body);  
        } 
        catch (ReturnValue returnValue) 
        {
            result = returnValue.getValue();  
        } 
        finally 
        {
            //pop after execution
            scopes.pop();
        }

        return result != null ? result : UNDEFINED;

    }

    //-------------
    // End of first section
    //--------------------

    // Create undefined value
    private static final Object UNDEFINED = new Object() {
        @Override
        public String toString() {
            return "Undefined";
        }
    };

    //--------------------------
    // Visit Declaration
    //------------------------
    @Override
    public Object visitDeclaration(PR1Parser.DeclarationContext decCtx) {
        // Ensure at least one scope is available
        if (scopes.isEmpty()) {
            scopes.push(new HashMap<>());
        }

        Map<String, Object> currentScope = scopes.peek();

        for (int i = 0; i < decCtx.ID().size(); i++) 
        {
            // initialize to default
            String id = decCtx.ID(i).getText();
            Object value = UNDEFINED; 

            //check if expression is there.
            if (decCtx.expression(i) != null) 
            {
                value = visit(decCtx.expression(i)); 
            }
            currentScope.put(id, value);
        }
        return null;
    }

    //------------------------
    // Visit Assignment
    //--------------------------
    @Override
    public Object visitAssignment(PR1Parser.AssignmentContext asgn) {
        String id = asgn.ID().getText();
        Object value = visit(asgn.expression());
    
        // Assign the variable in the nearest scope where it is defined
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, Object> scope = scopes.get(i);
            if (scope.containsKey(id)) {
                scope.put(id, value);
                return value;
            }
        }
        
        // Variable wasn't declared before assignment
        System.err.println("Error: Variable " + id + " is not declared.");
        return null;
    }

    //--------------------------
    // Expression
    //-----------------------
    public Object visitExpression(PR1Parser.ExpressionContext expr) {
        try 
        {
            return visitChildren(expr);
        }
        catch (RuntimeException e) 
        {
            System.err.println(e.getMessage());
            return null; 
        }
    }

    // Break


    //-------------------
    // Multi Division
    //-------------------------
    @Override
    public Object visitMulDiv(PR1Parser.MulDivContext mulDivCtx) {
        // create varaiables of each side of expression
        Object leftSide = visit(mulDivCtx.expression(0));
        Object rightSide = visit(mulDivCtx.expression(1));

        // check if it is integer or double objects

        //Integer
        if (leftSide instanceof Integer && rightSide instanceof Integer) 
        {
            return mulDivCtx.MULT() != null ? (Integer) leftSide * (Integer) rightSide : (Integer) leftSide / (Integer) rightSide;
        }
        //Double
        else if (leftSide instanceof Double || rightSide instanceof Double) 
        {
            return mulDivCtx.MULT() != null ? ((Number) leftSide).doubleValue() * ((Number) rightSide).doubleValue()
                                      : ((Number) leftSide).doubleValue() / ((Number) rightSide).doubleValue();
        }
        //Throw excpetion if neither.
        else 
        {
            //throw exception
            throw new RuntimeException("Invalid types for multiplication or division");
        }
    }

    //------------------------
    // Add - Sub
    //---------------------------
    @Override
    public Object visitAddSub(PR1Parser.AddSubContext addSubCtx) {
        //Create variables for each side (same as multi - div)
        Object leftSide = visit(addSubCtx.expression(0));
        Object rightSide = visit(addSubCtx.expression(1));
    
        // Check if either operand is undefined
        if (leftSide == UNDEFINED || rightSide == UNDEFINED) {
            throw new RuntimeException("Error: Unsupported operation with undefined operand");
        }
    
        // STEP 1: Check Addition
        if (addSubCtx.PLUS() != null) {
            //check if variables are integers, number, or strings
            if (leftSide instanceof Integer && rightSide instanceof Integer) 
            {
                return (Integer) leftSide + (Integer) rightSide;
            } 
            else if (leftSide instanceof Number && rightSide instanceof Number) 
            {
                return ((Number) leftSide).doubleValue() + ((Number) rightSide).doubleValue();
            } 
            else if (leftSide instanceof String || rightSide instanceof String) {
                return String.valueOf(leftSide) + String.valueOf(rightSide);
            }
            //STEP 2: Check Subtraction
        } else if (addSubCtx.MINUS() != null) 
        {
            //check if integer or number
            if (leftSide instanceof Integer && rightSide instanceof Integer) 
            {
                return (Integer) leftSide - (Integer) rightSide;
            }
            else if (leftSide instanceof Number && rightSide instanceof Number) 
            {
                return ((Number) leftSide).doubleValue() - ((Number) rightSide).doubleValue();
            }
        }
        //throw exception if nothing returned.
        throw new RuntimeException("Error: Unsupported operation");
    }

    //Break


    //-------------------------------
    // Visit Relational
    //------------------------------
    @Override
    public Object visitRelational(PR1Parser.RelationalContext relCtx) {
        // Create variables for left and right side
        Object leftSide = visit(relCtx.expression(0));
        Object rightSide = visit(relCtx.expression(1));

        //check the right and left side are both either integers or doubles
        if ((leftSide instanceof Integer || leftSide instanceof Double) && (rightSide instanceof Integer || rightSide instanceof Double)) 
        {
            //create values as doubles if numbers
            double leftVal = ((Number) leftSide).doubleValue();
            double rightVal = ((Number) rightSide).doubleValue();
            
            //check relationship of values
            if (relCtx.GT() != null) 
            {
                return leftVal > rightVal;
            }
            else if (relCtx.LT() != null)
            { 
                return leftVal < rightVal;
            }
            else if (relCtx.GTE() != null)
            {
                return leftVal >= rightVal;
            }
            else if (relCtx.LTE() != null)
            {
                 return leftVal <= rightVal;
            }
            else if (relCtx.EQ() != null)
            {
                 return leftVal == rightVal;
            }
            else if (relCtx.NEQ() != null)
            {
                return leftVal != rightVal;
            }
            //throw exception if nothing returned yet.
        } else {
            throw new RuntimeException("Error: Invalid types for relational operation");
        }
        return null; 
    }

    //---------------------------
    // Logical
    //--------------------------
    @Override
    public Object visitLogical(PR1Parser.LogicalContext logCtx) {
        //Create left/right side variables
        Object leftSide = visit(logCtx.expression(0));
        Object rightSide = visit(logCtx.expression(1));

        if (leftSide instanceof Boolean && rightSide instanceof Boolean) {
            //check if values are AND or OR.
            if (logCtx.AND() != null) 
            {
                return (Boolean) leftSide && (Boolean) rightSide;
            } 
            else if (logCtx.OR() != null) 
            {
                return (Boolean) leftSide || (Boolean) rightSide;
            }
        } else {
            throw new RuntimeException("Error: Invalid types for logical operation");
        }
        return null;
    }

    //--------------------
    // Not Expression
    //--------------------
    @Override
    public Object visitNotExpr(PR1Parser.NotExprContext ctx) {
        Object value = visit(ctx.expression());
        if (value instanceof Boolean) {
            return !(Boolean) value;
        } else {
            throw new RuntimeException("Error: Invalid type for NOT operation");
        }
    }

    //-----------------
    // Neg Expression
    //------------------
    @Override
    public Object visitNegExpr(PR1Parser.NegExprContext ctx) {
        Object value = visit(ctx.expression());
        if (value instanceof Integer) {
            return -(Integer) value;
        } else if (value instanceof Double) {
            return -(Double) value;
        } else {
            throw new RuntimeException("Error: Invalid type for negation");
        }
    }

    //Break

    //--------------------------
    // IF
    //------------------------
    @Override
    public Object visitIfState(PR1Parser.IfStateContext ctx) {
        //System.out.println("Evaluating if statement: " + ctx.getText());

        Object condition = visit(ctx.expression());

        if (!(condition instanceof Boolean)) {
            throw new RuntimeException("Error: Condition must be a boolean expression");
        }

        // if block
        if ((Boolean) condition) 
        {
            visitBlock(ctx.block(0));  
        } 
        //else block
        else if (ctx.block(1) != null) 
        {
            visitBlock(ctx.block(1));  
        }

        return null;
    }

    //--------------------
    // While
    //--------------------s
    @Override
    public Object visitWhileState(PR1Parser.WhileStateContext ctx) {
        try {
            while (true) {
                Object condition = visit(ctx.expression());
    
                if (!(condition instanceof Boolean)) {
                    throw new RuntimeException("Error: Condition must be a boolean expression");
                }
    
                if (!(Boolean) condition) {
                    break;
                }
    
                try {
                    visit(ctx.block());  // Execute the block
                } catch (ContinueException e) {
                    // continue to the next iteration
                    continue;
                } catch (BreakException e) {
                    // break out of the loop
                    break;
                }
            }
        } 
        catch (BreakException e) 
        {
            //ignore
        }
        return null;
    }

    //----------------
    // Return 
    //----------------
    @Override
    public Object visitReturnState(PR1Parser.ReturnStateContext ctx) {
        Object value = visit(ctx.expression());
        throw new ReturnValue(value);  // Signal a return with the specified value
    }

    @Override
    public Object visitBlock(PR1Parser.BlockContext ctx) {
        for (PR1Parser.StatementContext statement : ctx.statement()) 
        {
            visit(statement);
        }

        return null;
    }

    //--------------
    // Parentheses
    //---------------
    @Override
    public Object visitParenExpr(PR1Parser.ParenExprContext ctx) {
        return visit(ctx.expression());  
    }

    //---------------------
    // Literal
    //-----------------
    @Override
    public Object visitIntLiteral(PR1Parser.IntLiteralContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }

    //-----------------
    // Float
    //------------------
    @Override
    public Object visitFloatLiteral(PR1Parser.FloatLiteralContext ctx) {
        return Double.parseDouble(ctx.FLOAT().getText());
    }

    //--------------------
    // Boolean (TRUE)
    //-----------------
    @Override
    public Object visitBoolTrue(PR1Parser.BoolTrueContext ctx) {
        return true;
    }

    //--------------------
    // Boolean (false)
    //---------------------
    @Override
    public Object visitBoolFalse(PR1Parser.BoolFalseContext ctx) {
        return false;
    }

    //------------------------
    // String
    //-------------------
    @Override
    public Object visitStringLiteral(PR1Parser.StringLiteralContext ctx) {
        return ctx.STRING().getText().replaceAll("\"", "");  // Remove quotes from string
    }

    //--------------------
    // VAriable
    //-------------------
    @Override
    public Object visitVariable(PR1Parser.VariableContext ctx) {
        String id = ctx.ID().getText();
        /*Object value = memory.get(id);
        if (value == null) {
            System.err.println("Error: Variable " + id + " is undefined.");
            return null;
        }
        return value;*/
        return getValue(id);
    }

    //-------------------
    // Write
    //----------------
    @Override
    public Object visitWriteState(PR1Parser.WriteStateContext ctx) {
        Object value = visit(ctx.expression());  // Evaluate the expression
        System.out.println(value);
        return value;
    }

    //-------------------
    // Read
    //----------------
    @Override
    public Object visitReadState(PR1Parser.ReadStateContext ctx) {
        System.out.print("Enter value for " + ctx.ID().getText() + ": ");
        String input = scanner.nextLine();
        Object value;
        try {
            if (input.contains(".")) {
                value = Double.parseDouble(input);
            } else {
                value = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            value = input;  // If it's not a number, assume it's a string
        }
        memory.put(ctx.ID().getText(), value);
        return value;
    }

    //-----------------
    // Break
    //-------------
    @Override
    public Object visitBreakState(PR1Parser.BreakStateContext ctx) {
        throw new BreakException();
    }

    //------------------
    // Continue
    //----------------------
    @Override
    public Object visitContinueState(PR1Parser.ContinueStateContext ctx) {
        throw new ContinueException();
    }
}