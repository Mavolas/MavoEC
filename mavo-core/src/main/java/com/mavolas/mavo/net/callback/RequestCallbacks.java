package com.mavolas.mavo.net.callback;

import android.os.Handler;

import com.mavolas.mavo.ui.loader.LoaderStyle;
import com.mavolas.mavo.ui.loader.MavoLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 宋棋安
 * on 2018/9/26.
 */
public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error,LoaderStyle loaderStyle) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {

        if ( response.isSuccessful() ){
            if ( call.isExecuted() ){
                if ( SUCCESS != null ){

                    SUCCESS.onSuccess( response.body());
                }
            }

        }else {
            if ( ERROR != null ){
                ERROR.onError( response.code(), response.message() );
            }
        }

        stopLoading();

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

        if ( FAILURE != null ){

            if ( FAILURE != null ){
                FAILURE.onFailure();
            }
            if ( REQUEST != null ){
                REQUEST.onRequestEnd();
            }
        }

        stopLoading();

    }

    private void stopLoading(){

        if ( LOADER_STYLE !=null ){

            HANDLER.postDelayed( new Runnable( ) {
                @Override
                public void run() {
                    MavoLoader.stopLoading();
                }
            },1000 );

        }
    }
}
