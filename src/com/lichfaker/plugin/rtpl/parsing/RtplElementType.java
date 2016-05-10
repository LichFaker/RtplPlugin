package com.lichfaker.plugin.rtpl.parsing;

import com.intellij.psi.tree.IElementType;
import com.lichfaker.plugin.rtpl.lang.RtplLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RtplElementType extends IElementType {

  public RtplElementType(@NotNull @NonNls String debugName) {
    super(debugName, RtplLanguage.INSTANCE);
  }


}
