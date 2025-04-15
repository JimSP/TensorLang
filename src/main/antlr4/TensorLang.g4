grammar TensorLang;

/* ------------------------------------------------------------------
   [1] LEXER RULES
   Separando comentários de linha e de bloco em duas regras
-------------------------------------------------------------------*/

// Comentário de linha
LINE_COMMENT
  : '//' ~[\r\n]*
    -> skip
  ;

// Comentário de bloco
BLOCK_COMMENT
  : '/*' .*? '*/'
    -> skip
  ;

// Espaços
WS
  : [ \t\r\n]+ -> skip
  ;

// Palavras-chave e símbolos
PRINT       : 'print';
EQ          : '=';
FN          : 'fn';
LPAREN      : '(';
RPAREN      : ')';
ARROW       : '=>';
STAR        : '*';
SLASH       : '/';
PLUS        : '+';
MINUS       : '-';
EQUAL_EQUAL : '==';
NOT_EQUAL   : '!=';
LT          : '<';
LTE         : '<=';
GT          : '>';
GTE         : '>=';
AND         : '&&';
OR          : '||';
LBRACK      : '[';
RBRACK      : ']';
COMMA       : ',';
QUOTE       : '\'';

/* Identificadores, números, strings etc. */

BOOL
  : 'true'
  | 'false'
  ;

ID
  : [a-zA-Z_][a-zA-Z0-9_]*
  ;

NUMBER
  : [0-9]+ ('.' [0-9]+)?
  ;

STRING
  : '"' ( ~["\\] | '\\' . )* '"'
  ;

CHAR
  : ~['\\]
  | '\\' .
  ;

/* ------------------------------------------------------------------
   [2] PARSER RULES
   (mesmas regras de parser que você já tinha)
-------------------------------------------------------------------*/

program
  : statement* EOF
  ;

statement
  : assign
  | print
  | expr
  ;

assign
  : ID EQ expr
  ;

print
  : PRINT expr
  ;

expr
  : MINUS expr         #UnaryNeg
  | fnExpr             #ExprFn
  ;

fnExpr
  : FN LPAREN paramList? RPAREN ARROW expr  #FunctionDef
  | binaryExpr                              #ExprBinary
  ;

binaryExpr
  : binaryExpr op=(STAR|SLASH|PLUS|MINUS
                   |EQUAL_EQUAL|NOT_EQUAL
                   |LT|LTE
                   |GT|GTE
                   |AND|OR)
    binaryExpr                              #BinaryOp
  | applyExpr                               #ExprApply
  ;

applyExpr
  : primaryExpr (LPAREN argList? RPAREN)*   #FunctionCall
  ;

primaryExpr
  : LPAREN expr RPAREN                      #Parens
  | literal                                 #LiteralExpr
  | ID                                      #VarExpr
  ;

literal
  : NUMBER                                  #NumberLiteral
  | STRING                                  #StringLiteral
  | BOOL                                    #BoolLiteral
  | QUOTE CHAR QUOTE                        #CharLiteral
  | LBRACK exprList? RBRACK                 #VectorLiteral
  ;

exprList
  : expr (COMMA expr)*
  ;

paramList
  : ID (COMMA ID)*
  ;

argList
  : expr (COMMA expr)*
  ;