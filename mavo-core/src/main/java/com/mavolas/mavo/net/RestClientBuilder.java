package com.mavolas.mavo.net;

import android.content.Context;

import com.mavolas.mavo.net.callback.IError;
import com.mavolas.mavo.net.callback.IFailure;
import com.mavolas.mavo.net.callback.IRequest;
import com.mavolas.mavo.net.callback.ISuccess;
import com.mavolas.mavo.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 宋棋安
 * on 2018/9/25.
 */
public class RestClientBuilder {

    private String mUrl = null;
    private Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest = null;
    private ISuccess mSuccess = null;
    private IFailure mFailure = null;
    private IError mError = null;
    private RequestBody mBody = null;
    private File mFile = null;
    private String mDownload_dir;
    private String mExtension;
    private String mName;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;

    public RestClientBuilder() {
    }

    public final RestClientBuilder url(String url){

        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){

        this.PARAMS.putAll( params );
        return this;
    }

    public final RestClientBuilder params(String key,Object value){

        this.PARAMS.put( key,value );
        return this;
    }

    public final RestClientBuilder file(File file){

        this.mFile = file;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownload_dir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder file(String filePath){

        this.mFile = new File( filePath );
        return this;
    }

    public final RestClientBuilder raw(String raw){

        this.mBody = RequestBody.create( MediaType.parse( "application/json;charset=UTF-8" ) ,raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){

        this.mRequest = iRequest;
        return this;
    }


    public final RestClientBuilder success(ISuccess iSuccess){

        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder error(IError iError){

        this.mError = iError;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){

        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style){

        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context){

        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }


    public final RestClient build(){

        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mFailure, mError ,mBody ,mFile
                ,mDownload_dir, mExtension ,mName ,mLoaderStyle, mContext );

    }



}
