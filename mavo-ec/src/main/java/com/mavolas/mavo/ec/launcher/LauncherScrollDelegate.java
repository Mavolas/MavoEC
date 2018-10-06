package com.mavolas.mavo.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.mavolas.mavo.delegates.MavoDelegate;
import com.mavolas.mavo.ec.R;
import com.mavolas.mavo.ui.launcher.LauncherHolderCreator;
import com.mavolas.mavo.ui.launcher.ScrollLauncherTag;
import com.mavolas.mavo.util.MavoPreference;

import java.util.ArrayList;

/**
 * Created by 宋棋安
 * on 2018/9/27.
 */
public class LauncherScrollDelegate extends MavoDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mIntegerConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList <>(  );

    private void initBanner(){
        INTEGERS. add( R.mipmap.launcher_01 );
        INTEGERS. add( R.mipmap.launcher_02 );
        INTEGERS. add( R.mipmap.launcher_03 );
        INTEGERS. add( R.mipmap.launcher_04 );
        INTEGERS. add( R.mipmap.launcher_05 );

        mIntegerConvenientBanner
                .setPages( new LauncherHolderCreator() ,INTEGERS )
                .setPageIndicator( new int[]{R.drawable.dot_normal, R.drawable.dot_focus} )
                .setPageIndicatorAlign( ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL )
                .setOnItemClickListener( this )
                .setCanLoop( false );


    }

    @Override
    public Object setLayout() {
        mIntegerConvenientBanner = new ConvenientBanner <>( getContext() );
        return mIntegerConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        initBanner();
    }


    @Override
    public void onItemClick(int position) {
        //如果点击的是最后一个
        if ( position == INTEGERS.size() - 1 ){

            MavoPreference.setAppFlag( ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true );
            //检查用户是否已经登录

        }


    }
}
