package com.mavolas.mavoec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.mavolas.mavo.appconfig.App;
import com.mavolas.mavo.ec.icon.FontEcModule;

/**
 * Created by 宋棋安
 * on 2018/9/21.
 */
public class ECApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate( );

        App.init( this )
                .withIcon( new FontAwesomeModule() )
                .withIcon( new FontEcModule() )
                .withApiHost( "http://127.0.0.1/" )
                .configure();
    }
}
