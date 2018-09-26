package com.mavolas.mavo.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.mavolas.mavo.R;
import com.mavolas.mavo.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by 宋棋安
 * on 2018/9/26.
 */
public class MavoLoader {

    private static final int LOADING_SIZE_SCALE = 8;
    private static final int LOADING_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList <>(  );
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context,Enum<LoaderStyle> type){
        showLoading( context,type.name() );
    }


    public static void showLoading(Context context,String type){

        final AppCompatDialog dialog = new AppCompatDialog( context , R.style.dialog );

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create( type ,context );
        dialog.setContentView( avLoadingIndicatorView );

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if ( dialogWindow != null ){

            WindowManager.LayoutParams lp = dialogWindow.getAttributes();

            lp.width = deviceWidth / LOADING_SIZE_SCALE;
            lp.height = deviceHeight / LOADING_SIZE_SCALE;
            lp.height = lp.height+deviceHeight/LOADING_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }

        LOADERS.add( dialog );
        dialog.show();

    }

    public static void showLoading(Context context){
        showLoading( context,DEFAULT_LOADER );
    }

    public static void stopLoading(){
        for (AppCompatDialog dialog : LOADERS) {
            if ( dialog != null ){
                if ( dialog.isShowing() ){
                    dialog.cancel();
                }
            }
        }
    }
}
