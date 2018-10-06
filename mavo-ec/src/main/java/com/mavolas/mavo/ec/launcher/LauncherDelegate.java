package com.mavolas.mavo.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.mavolas.mavo.delegates.MavoDelegate;
import com.mavolas.mavo.ec.R;
import com.mavolas.mavo.ec.R2;
import com.mavolas.mavo.ui.launcher.ScrollLauncherTag;
import com.mavolas.mavo.util.MavoPreference;
import com.mavolas.mavo.util.timer.BaseTimerTask;
import com.mavolas.mavo.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 宋棋安
 * on 2018/9/27.
 */
public class LauncherDelegate extends MavoDelegate implements ITimerListener {


    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView(){

        if ( mTimer !=null ){
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }

    }

    private void initTimer(){
        mTimer = new Timer( );
        final BaseTimerTask task = new BaseTimerTask( this );

        mTimer.schedule( task,0,1000 );
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        initTimer();
    }

    //判断是否启动启动页
    private void checkIsShowScroll(){

        if ( !MavoPreference.getAppFlag( ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name() ) ){

            start( new LauncherScrollDelegate(), SINGLETASK );
        } else {

            //检查用户是否登录
        }


    }

    @Override
    public void onTimer() {

        getProxyActivity().runOnUiThread( new Runnable( ) {
            @Override
            public void run() {
                if ( mTvTimer != null ){
                    mTvTimer.setText( MessageFormat.format( "跳过\n{0}s",mCount ) );
                    mCount--;
                    if ( mCount < 0 ){
                        if ( mTimer !=null ){
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        } );
    }

}
