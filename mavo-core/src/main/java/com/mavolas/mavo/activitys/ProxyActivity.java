package com.mavolas.mavo.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;


import com.mavolas.mavo.R;
import com.mavolas.mavo.delegates.MavoDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by 宋棋安
 * on 2018/9/21.
 */
public abstract class ProxyActivity extends SupportActivity {

    public abstract MavoDelegate setRootDelegate();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        initContainer(savedInstanceState);
    }

    @SuppressLint("RestrictedApi")
    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container =new ContentFrameLayout( this );

        container.setId( R.id.delegate_container );

        setContentView( container );

        if ( savedInstanceState == null ){

            loadRootFragment( R.id.delegate_container ,setRootDelegate() );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy( );

        System.gc();
        System.runFinalization();

    }
}
