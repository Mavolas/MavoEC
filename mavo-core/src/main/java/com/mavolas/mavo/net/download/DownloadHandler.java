package com.mavolas.mavo.net.download;

import android.os.AsyncTask;

import com.mavolas.mavo.net.RestCreator;
import com.mavolas.mavo.net.callback.IError;
import com.mavolas.mavo.net.callback.IFailure;
import com.mavolas.mavo.net.callback.IRequest;
import com.mavolas.mavo.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 宋棋安
 * on 2018/9/26.
 */
public class DownloadHandler {

    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String URL, IRequest REQUEST, String DOWNLOAD_DIR, String EXTENSION, String NAME, ISuccess SUCCESS, IFailure FAILURE, IError ERROR) {
        this.URL = URL;
        this.REQUEST = REQUEST;
        this.DOWNLOAD_DIR = DOWNLOAD_DIR;
        this.EXTENSION = EXTENSION;
        this.NAME = NAME;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
    }

    public final void HandleDownload(){

        if ( REQUEST != null ){

            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download( URL, PARAMS )
                .enqueue( new Callback <ResponseBody>( ) {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        if ( response.isSuccessful() ){
                            final ResponseBody responseBody = response.body();

                            final SaveFileTask task = new SaveFileTask( REQUEST ,SUCCESS );
                            task.executeOnExecutor( AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,responseBody,NAME );

                            //这里一定要注意判断，可能文件下载不全
                            if ( task.isCancelled() ){
                                if ( REQUEST != null ){
                                    REQUEST.onRequestEnd();
                                }
                            }
                        }else {

                            if ( ERROR != null ){
                                ERROR.onError( response.code(), response.message() );
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call <ResponseBody> call, Throwable t) {
                        if ( FAILURE != null ){
                            FAILURE.onFailure();
                        }

                    }
                } );

    }
}
