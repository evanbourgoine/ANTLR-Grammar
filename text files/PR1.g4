grammar PR1;

// Evan Bourgoine
// Project 1 Grammar FloatLiteral

//------------------------
//KEYWORD DEFINITIONS
//-------------------------
VAR     : 'var' ;
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;
WRITE   : 'write' ;
FUNCTION : 'function' ;
READ    : 'read' ;
RETURN  : 'return' ;
BREAK   : 'break' ;
CONTINUE: 'continue' ;

//---------------------------
// ARITHMATIC
//---------------------------
ASSIGN  : '=' ;
PLUS    : '+' ;
MINUS   : '-' ;
DIV     : '/' ;
MULT    : '*' ;
EQ      : '==' ;
NEQ     : '!=' ;
GT      : '>' ;
LT      : '<' ;
GTE     : '>=' ;
LTE     : '<=' ;
AND     : '&&' ;
OR      : '||' ;
NOT     : '!' ;


SEMI    : ';' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
LBRACE  : '{' ;
RBRACE  : '}' ;

STRING  : '"' (~["\r\n])* '"' ;
TRUE    : 'true' ;
FALSE   : 'false' ;
INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]* ;
ID      : [a-zA-Z_][a-zA-Z_0-9]* ;
WS      : [ \t\r\n]+ -> skip ;

//-------------------------------------------
//              RULES
//--------------------------------------------

prog:   statement* EOF ;
statement:  (assignment | declaration | ifState | whileState | writeState | readState | returnState | breakState | continueState | block | functionDecl | functionCall) SEMI? ;

//---------------------------------------
//          FUNCTION CALLS
//------------------------------------------

functionDecl: FUNCTION ID LPAREN (ID (',' ID)*)? RPAREN block ;
functionCall: ID LPAREN (expression (',' expression)*)? RPAREN ;

//----------------------------------------------
//          VARIABLE ASSIGNMENTS
//----------------------------------------------

assignment: ID ASSIGN expression ;
declaration: VAR ID (ASSIGN expression)? (',' ID (ASSIGN expression)?)* ;

//----------------------------------------------
//                  LOOPS
//----------------------------------------------

ifState: IF LPAREN expression RPAREN block (ELSE block)? ;
whileState: WHILE LPAREN expression RPAREN block ;

//--------------------------------------------
//              BREAK & CONTINUE
//----------------------------------------------

breakState: BREAK ;
continueState: CONTINUE ;

block:  LBRACE statement* RBRACE ;

//-----------------------------------------
//              READ & WRITE
//----------------------------------------

writeState: WRITE LPAREN expression RPAREN ;
readState:  ID ASSIGN READ LPAREN RPAREN ;

returnState: RETURN expression ;

//--------------------------------------
//              EXPRESSIONS
//-------------------------------------

expression
    : expression (MULT | DIV) expression   # MulDiv
    | expression (PLUS | MINUS) expression  # AddSub
    | expression (EQ | NEQ | GT | LT | GTE | LTE) expression  # Relational
    | expression (AND | OR) expression      # Logical
    | NOT expression                        # NotExpr
    | MINUS expression                      # NegExpr
    | LPAREN expression RPAREN              # ParenExpr
    | functionCall                          # FunctionCallExpr
    | INT                                   # IntLiteral
    | FLOAT                                 # FloatLiteral
    | TRUE                                  # BoolTrue
    | FALSE                                 # BoolFalse
    | STRING                                # StringLiteral
    | ID                                    # Variable
    ;
