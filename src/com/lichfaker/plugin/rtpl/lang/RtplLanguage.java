package com.lichfaker.plugin.rtpl.lang;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

/**
 * Created by lichfaker on 16/5/10.
 */
public class RtplLanguage extends Language {

    public static final String NAME = "Rtpl";

    public static final Language INSTANCE = new RtplLanguage();

    protected RtplLanguage() {
        super(NAME);
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
