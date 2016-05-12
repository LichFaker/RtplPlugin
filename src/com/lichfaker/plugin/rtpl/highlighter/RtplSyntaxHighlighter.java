package com.lichfaker.plugin.rtpl.highlighter;

import com.intellij.ide.highlighter.XmlFileHighlighter;
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
    // KEYWORD,NUMBER,STRING,INSTANCE_FIELD,INSTANCE_METHOD,CONSTANT
    public static final TextAttributesKey COMMENT = createTextAttributesKey("RTPL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("RTPL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey ATTRIBUTATE = createTextAttributesKey("RTPL_ATTRIBUTATE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SYMBOL = createTextAttributesKey("RTPL_SYMBOL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("RTPL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey INSTRUCTION = createTextAttributesKey("RTPL_INSTRUCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey CONSTANT = createTextAttributesKey("RTPL_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey SPECIAL_SYMBOL = createTextAttributesKey("RTPL_SPECIAL_SYMBOL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("RTPL_BAD_CHARACTER", new TextAttributes(Color.RED, null, null, null, Font.BOLD));

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
        } else if (tokenType.equals(RtplElementTypes.ATTRIBUTATE)) {
            return pack(ATTRIBUTATE);
        } else if (tokenType.equals(RtplElementTypes.COMMENT)) {
            return pack(COMMENT);
        } else if (tokenType.equals(RtplElementTypes.SYMBOL)) {
            return pack(SYMBOL);
        }
        else {
            return EMPTY;
        }
    }
}
