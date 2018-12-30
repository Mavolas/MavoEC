package com.mavolas.mavo.ui.refresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import com.mavolas.mavo.appconfig.App;

/**
 * Author by Andy
 * Date on 2018/12/25.
 */
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;


    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        REFRESH_LAYOUT.setRefreshing(true);

        Handler handler = App.getHandler();

        App.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {

                REFRESH_LAYOUT.setRefreshing(false);

            }
        },2000);


    }
}
