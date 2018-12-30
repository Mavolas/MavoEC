package com.mavolas.mavo.appconfig;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created by 宋棋安
 * on 2018/9/20.
 */
public final class App {

    public static Configurator init(Context context){

        getConfigurations().put( ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext() );

        return Configurator.getInstance();
    }


    public static HashMap<Object,Object> getConfigurations(){

        return Configurator.getInstance().getMavoConfigs();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Enum<ConfigType> key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }
}
