package com.mavolas.mavo.appconfig;

import android.content.Context;

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


    private static HashMap<String,Object> getConfigurations(){

        return Configurator.getInstance().getMavoConfigs();
    }
}
