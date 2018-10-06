package com.mavolas.mavoec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.mavolas.mavo.delegates.MavoDelegate;
import com.mavolas.mavo.net.RestClient;
import com.mavolas.mavo.net.callback.IError;
import com.mavolas.mavo.net.callback.IFailure;
import com.mavolas.mavo.net.callback.ISuccess;

/**
 * Created by 宋棋安
 * on 2018/9/25.
 */
public class ExampleDelegate extends MavoDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        testRestClient();
    }


    private void testRestClient(){

        RestClient.builder()
                .url( "http://127.0.0.1/index" )
                .loader( getContext() )
                .success( new ISuccess( ) {
                    @Override
                    public void onSuccess(String response) {

                       Toast.makeText( getContext(),response,Toast.LENGTH_LONG ).show();

                    }
                } )
                .failure( new IFailure( ) {
                    @Override
                    public void onFailure() {

                    }
                } )
                .error( new IError( ) {
                    @Override
                    public void onError(int code, String msg) {

                    }
                } )
                .build()
                .get();



    }
}
