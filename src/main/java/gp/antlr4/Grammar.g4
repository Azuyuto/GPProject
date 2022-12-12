grammar Grammar;

/*
 * Parser Rules
 */
init
    :   INIT LEFT_BRACE statement RIGHT_BRACE EOF ;

statement
    :   statement single_statement
    |   single_statement ;

single_statement
    :   (variable_declaration SEMI)
    |   (io_functions SEMI)
    |   block_statement
    |   conditional_statement
    |   iteration_statement ;

variable_declaration
    :   ID ASSIGN equation ;

io_functions
    :   ID ASSIGN IN
    |   OUT ASSIGN factor ;

block_statement
    :   LEFT_BRACE statement RIGHT_BRACE ;

conditional_statement
    :   IF LEFT_PAREN expression RIGHT_PAREN block_statement (ELSE (block_statement | conditional_statement))? ;

iteration_statement
    :   FOR LEFT_PAREN variable_declaration SEMI expression SEMI variable_declaration RIGHT_PAREN block_statement ;

expression
    :   expression (OR | AND) expression
    |   expression (GREATER_THEN | LESS_THEN) expression
    |   expression (GREATER_EQUAL_THEN | LESS_EQUAL_THEN) expression
    |   expression (EQUAL | NOT_EQUAL) expression
    |   LEFT_PAREN expression RIGHT_PAREN
    |   NOT expression
    |   equation ;

equation
   :   equation (TIMES | DIV)  equation
   |   equation (PLUS | MINUS) equation
   |   LEFT_PAREN equation RIGHT_PAREN
   |   (PLUS | MINUS)* factor
   ;

factor
   :   ID
   |   INT ;

/*
 * Lexer Rules
 */
fragment DIGIT    : [0-9]    ;
fragment LETTER   : [a-zA-Z] ;

IF              : 'if'      ;
ELSE            : 'else'    ;
FOR             : 'for'     ;
IN              : 'in'      ;
OUT             : 'out'     ;
INIT            : 'init'    ;

SEMI            : ';';

LEFT_PAREN      : '(';
RIGHT_PAREN     : ')';
LEFT_BRACE      : '{';
RIGHT_BRACE     : '}';

PLUS            : '+' ;
MINUS           : '-' ;
TIMES           : '*' ;
DIV             : '/' ;
ASSIGN          : '=' ;

GREATER_THEN        : '>'  ;
GREATER_EQUAL_THEN  : '>=' ;
LESS_THEN           : '<'  ;
LESS_EQUAL_THEN     : '<=' ;
AND                 : '&&' ;
OR                  : '||' ;
NOT                 : '!'  ;
EQUAL               : '==' ;
NOT_EQUAL           : '!=' ;

ID              : LETTER (LETTER | DIGIT)*  ;
INT             : DIGIT+                    ;

WHITESPACE      : (' ' | '\t') -> skip          ;
NEWLINE         : ('\r'? '\n' | '\r')+ -> skip  ;