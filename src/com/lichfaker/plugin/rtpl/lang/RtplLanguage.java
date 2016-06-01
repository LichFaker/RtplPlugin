package com.lichfaker.plugin.rtpl.lang;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.lichfaker.plugin.rtpl.highlighter.RtplSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * Created by lichfaker on 16/5/10.
 */
public class RtplLanguage extends Language {

    public static final String NAME = "Rtpl";

    public static final Language INSTANCE = new RtplLanguage();

    protected RtplLanguage() {
        super(NAME);
        SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this,
                new SingleLazyInstanceSyntaxHighlighterFactory() {
                    @NotNull
                    protected SyntaxHighlighter createHighlighter() {
                        return new RtplSyntaxHighlighter();
                    }
                }
        );
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Rtpl";
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
