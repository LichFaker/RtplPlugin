package com.lichfaker.plugin.rtpl.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.lichfaker.plugin.rtpl.file.RtplFileType;
import com.lichfaker.plugin.rtpl.lang.RtplLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * @author lichfaker
 * @email lichfaker@gmail.com
 * @time 16/5/31
 */
public class RtplPsiFileImpl extends PsiFileBase {

    public RtplPsiFileImpl(@NotNull FileViewProvider fileViewProvider) {
        super(fileViewProvider, RtplLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RtplFileType.INSTANCE;
    }
}
