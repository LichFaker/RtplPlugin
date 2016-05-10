package com.lichfaker.plugin.rtpl.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.lichfaker.plugin.rtpl.lang.RtplLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by lichfaker on 16/5/4.
 */
public class RtplFileType extends LanguageFileType {

    public final static RtplFileType INSTANCE = new RtplFileType();

    public final static String[] DEFAULT_EXTENSIONS = {"rtpl"};

    protected RtplFileType() {
        super(RtplLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Rtpl";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Support For Rtpl";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSIONS[0];
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
