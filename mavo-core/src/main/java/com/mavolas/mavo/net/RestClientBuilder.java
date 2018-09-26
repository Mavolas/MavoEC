package com.mavolas.mavo.net;

import com.mavolas.mavo.net.callback.IError;
import com.mavolas.mavo.net.callback.IFailure;
import com.mavolas.mavo.net.callback.IRequest;
import com.mavolas.mavo.net.callback.ISuccess;

import java.lang.annotation.Target;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 宋棋安
 * on 2018/9/25.
 */
public class RestClientBuilder {

    private  String mUrl;
    private  Map<String,Object> PARAMS = RestCreator.getParams();
    private  IRequest mRequest;
    private  ISuccess mSuccess;
    private  IFailure mFailure;
    private  IError mError;
    private  RequestBody mBody;


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


    public final RestClient build(){

        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mFailure, mError ,mBody  );
    }



}
