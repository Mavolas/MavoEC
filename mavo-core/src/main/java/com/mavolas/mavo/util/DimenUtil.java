package com.mavolas.mavo.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.mavolas.mavo.appconfig.App;

/**
 * Created by 宋棋安
 * on 2018/9/26.
 */
public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = App.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;

    }

    public static int getScreenHeight(){
        final Resources resources = App.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;

    }
}
