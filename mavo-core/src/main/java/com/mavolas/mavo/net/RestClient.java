package com.mavolas.mavo.net;

import android.content.Context;

import com.mavolas.mavo.net.callback.IError;
import com.mavolas.mavo.net.callback.IFailure;
import com.mavolas.mavo.net.callback.IRequest;
import com.mavolas.mavo.net.callback.ISuccess;
import com.mavolas.mavo.net.callback.RequestCallbacks;
import com.mavolas.mavo.net.download.DownloadHandler;
import com.mavolas.mavo.ui.loader.LoaderStyle;
import com.mavolas.mavo.ui.loader.MavoLoader;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by 宋棋安
 * on 2018/9/25.
 */
public class RestClient {

    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final File FILE;
    private final Context CONTEXT;

    public RestClient(String url, Map <String, Object> params, IRequest request, ISuccess success
            , IFailure failure, IError error, RequestBody body, File file, String download_dir, String extension, String name
            , LoaderStyle loaderStyle, Context context) {

        this.URL = url;
        PARAMS.putAll( params );
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.LOADER_STYLE = loaderStyle;
        this.FILE = file;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.CONTEXT = context;
    }

    public static RestClientBuilder builder(){

        return new RestClientBuilder();
    }

    private void request(HttpMethod method){

        final RestService service = RestCreator.getRestService();

        Call<String> call = null;

        if ( REQUEST != null ){
            REQUEST.onRequestStart();
        }

        if ( LOADER_STYLE !=null ){
            MavoLoader.showLoading( CONTEXT, LOADER_STYLE );
        }

        switch (method){
            case GET:
                call = service.get( URL,PARAMS );
                break;
            case POST:
                call = service.post( URL, PARAMS );
                break;
            case POST_RAW:
                call = service.postRaw( URL, BODY );
                break;
            case PUT:
                call = service.put( URL, PARAMS );
                break;
            case PUT_RAW:
                call = service.putRaw( URL, BODY );
                break;
            case DELETE:
                call = service.delete( URL, PARAMS );
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create( MediaType.parse( MultipartBody.FORM.toString()),FILE );
                final MultipartBody.Part body = MultipartBody.Part.createFormData( "file" ,FILE.getName() ,requestBody);
                call = RestCreator.getRestService().upload( URL,body );
                break;
            default:
                break;


        }

        if ( call !=null ){
            call.enqueue( getRequestCallback() );

        }

    }


    private Callback<String> getRequestCallback(){

        return new RequestCallbacks( REQUEST, SUCCESS, FAILURE, ERROR, LOADER_STYLE);
    }

    public final void get(){
        request( HttpMethod.GET );
    }

    public final void post(){

        if ( BODY == null ) {
            request( HttpMethod.POST );
        }else {
            if ( !PARAMS.isEmpty() ){
                throw  new RuntimeException( "params must be null!" );
            }
            request( HttpMethod.POST_RAW );
        }
    }

    public final void put(){

        if ( BODY == null ) {
            request( HttpMethod.PUT );
        }else {
            if ( !PARAMS.isEmpty() ){
                throw  new RuntimeException( "params must be null!" );
            }
            request( HttpMethod.PUT_RAW );
        }
    }

    public final void delete(){
        request( HttpMethod.DELETE );
    }

    public final void upload(){
        request( HttpMethod.UPLOAD );
    }

    public final void download(){

        new DownloadHandler( URL, REQUEST, DOWNLOAD_DIR, EXTENSION, NAME, SUCCESS, FAILURE, ERROR)
                .HandleDownload();
    }
 }


