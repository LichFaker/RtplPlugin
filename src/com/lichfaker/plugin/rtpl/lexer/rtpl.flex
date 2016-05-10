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


LineTerminator          = \r|\n|\r\n
InputCharacter          = [^\r\n]
WhiteSpace              = [ \t]
Comment                 = [#] {InputCharacter}*
StringSq                = \'([^\\\'\r\n]|\\[^\r\n])*(\')
StringDq                = \"([^\\\"])*(\")
String                  = {StringSq}|{StringDq}
//Identifier              = [:jletter:][:jletterdigit:]*

%state String

%%

{LineTerminator}        { return NEWLINE;}
{WhiteSpace}+           { return TokenType.WHITE_SPACE; }
{Comment}               { return COMMENT; }
{String}                { return STRING; }
.                       { return BAD_CHARACTER; }