package com.lichfaker.plugin.rtpl.lexer;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.lichfaker.plugin.rtpl.parsing.RtplElementTypes;

%%

%class RtplLexer
%implements FlexLexer, RtplElementTypes
%unicode
%function advance
%type IElementType

%{
    boolean isComment = false;
%}


LineTerminator          = \r|\n|\r\n
InputCharacter          = [^\r\n]
WhiteSpace              = [ \t]
Comment_begin           = [<][\\\!][\\\-]
Comment_end             = [\\\-][\\\>]
StringSq                = \'([^\\\'\r\n]|\\[^\r\n])*(\')
StringDq                = \"([^\\\"])*(\")
String                  = {StringSq}|{StringDq}
Identifier              = [a-zA-Z_][a-zA-Z0-9_]*
Attributate             = {WhiteSpace}+{Identifier}(\\\:{Identifier})*{WhiteSpace}*={WhiteSpace}*
Symbol                  = =|\{|\}|\(|\)|=>|\.

%state S_STRING

%%

<YYINITIAL, S_STRING> {
    {Comment_begin}         { isComment = true; return COMMENT;}
    {Comment_end}           { isComment = false; return COMMENT;}
    {LineTerminator}        { if(isComment) {return COMMENT;}return NEWLINE;}
    {WhiteSpace}+           { if(isComment) {return COMMENT;}return TokenType.WHITE_SPACE; }
    {String}                { if(isComment) {return COMMENT;}return STRING; }
    {Symbol}                { if(isComment) {return COMMENT;}return SYMBOL; }
    {Attributate}           { if(isComment) {return COMMENT;}return ATTRIBUTATE; }
    .                       { if(isComment) {return COMMENT;}return BAD_CHARACTER;}
}

.                           {return BAD_CHARACTER;}