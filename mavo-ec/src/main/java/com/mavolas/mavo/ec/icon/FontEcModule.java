package com.mavolas.mavo.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by 宋棋安
 * on 2018/9/21.
 */
public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {

        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return  EcIcons.values();
    }
}
