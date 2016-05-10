package com.lichfaker.plugin.rtpl.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by lichfaker on 16/5/4.
 */
public class RtplFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        for (String type : RtplFileType.DEFAULT_EXTENSIONS) {
            fileTypeConsumer.consume(RtplFileType.INSTANCE, type);
        }
    }

}
