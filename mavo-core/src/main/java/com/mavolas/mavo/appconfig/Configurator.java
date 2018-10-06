package com.mavolas.mavo.appconfig;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * Created by 宋棋安
 * on 2018/9/20.
 */
public class Configurator {

    private static final HashMap<Object,Object> MAVO_CONFIGS = new HashMap <>(  );
    private static final ArrayList<IconFontDescriptor> ICOINS = new ArrayList <>(  );
    private static final ArrayList<Interceptor> INTERCEPTOR = new ArrayList <>(  );


    private Configurator(){

        MAVO_CONFIGS.put( ConfigType.CONFIG_READY.name(),false );

    }

    public static Configurator getInstance(){

        return Holder.INSTANCE;
    }

    final HashMap<Object,Object> getMavoConfigs(){

        return MAVO_CONFIGS;
    }

    //静态内部类，线程安全的懒汉模式
    private static class Holder{

        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){

        initIcons();
        MAVO_CONFIGS.put( ConfigType.CONFIG_READY.name(),true );
    }


    public final Configurator withApiHost(String host){

        MAVO_CONFIGS.put( ConfigType.API_HOST.name(),host );

        return this;
    }

    private void checkConfiguration(){

        final boolean isReady= ( boolean ) MAVO_CONFIGS.get( ConfigType.CONFIG_READY.name() );

        if ( !isReady ){

            throw new RuntimeException( "Configuartion is not ready, call configure" );
        }
    }

    private void initIcons(){

        if ( ICOINS.size()>0 ){

            final Iconify.IconifyInitializer initializer =Iconify.with( ICOINS.get( 0 ) );

            for (int i=1;i<ICOINS.size();i++){

                initializer.with( ICOINS.get( i ) );
            }

        }

    }


    public final Configurator withIcon(IconFontDescriptor descriptor){

        ICOINS.add( descriptor );

        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptor){

        INTERCEPTOR.add( interceptor );
        MAVO_CONFIGS.put( ConfigType.INTERCEPTOR.name(),INTERCEPTOR );

        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors){

        INTERCEPTOR.addAll( interceptors );
        MAVO_CONFIGS.put( ConfigType.INTERCEPTOR.name(),INTERCEPTOR );

        return this;
    }


    @SuppressWarnings( "unchecked" )
    final <T> T getConfiguration(Enum<ConfigType> key){

        checkConfiguration();
        return ( T ) MAVO_CONFIGS.get( key.name() );

    }


}
