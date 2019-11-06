grammar SelectExample1;
sql : 'select' WHAT 'from' tables ';';
WHAT : [a-z]+ ;
tables : WHAT;
WS : [ \t\r\n]+ -> skip ;