package com.lichfaker.plugin.rtpl.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.XmlHighlightingLexer;
import com.intellij.lexer.XmlLexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.lichfaker.plugin.rtpl.lexer.RtplLexerAdapter;
import com.lichfaker.plugin.rtpl.parsing.RtplElementTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import java.awt.*;

/**
 * Created by lichfaker on 16/5/4.
 */
public class RtplSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT = createTextAttributesKey("NSIS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("NSIS_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NSIS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("NSIS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey BLOCK_DECLARATION = createTextAttributesKey("NSIS_BLOCK", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("NSIS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey INSTRUCTION = createTextAttributesKey("NSIS_INSTRUCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey CONSTANT = createTextAttributesKey("NSIS_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey SPECIAL_SYMBOL = createTextAttributesKey("NSIS_SPECIAL_SYMBOL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("NSIS_BAD_CHARACTER", new TextAttributes(Color.RED, null, null, null, Font.BOLD));


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new RtplLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(RtplElementTypes.STRING)) {
            return pack(STRING);
        } else if (tokenType.equals(RtplElementTypes.NUMBER)) {
            return pack(NUMBER);
        } else if (tokenType.equals(RtplElementTypes.IDENTIFIER)) {
            return pack(IDENTIFIER);
        } else if (tokenType.equals(RtplElementTypes.INSTRUCTION)) {
            return pack(INSTRUCTION);
        } else if (tokenType.equals(RtplElementTypes.BLOCK_DECLARATION)) {
            return pack(BLOCK_DECLARATION);
        } else if (tokenType.equals(RtplElementTypes.COMMENT)) {
            return pack(COMMENT);
        } else if (tokenType.equals(RtplElementTypes.CONSTANT) || tokenType.equals(RtplElementTypes.VALUE) || tokenType.equals(RtplElementTypes.VARIABLE)) {
            return pack(CONSTANT);
        } else if (tokenType.equals(RtplElementTypes.KEYWORD)) {
            return pack(KEYWORD);
        } else if (tokenType.equals(RtplElementTypes.SPECIAL_SYMBOL)) {
            return pack(SPECIAL_SYMBOL);
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return pack(BAD_CHARACTER);
        } else {
            return EMPTY;
        }
    }
}
