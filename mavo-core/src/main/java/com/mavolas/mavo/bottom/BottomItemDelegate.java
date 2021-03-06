package com.mavolas.mavo.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.mavolas.mavo.R;
import com.mavolas.mavo.delegates.MavoDelegate;

/**
 * Author by Andy
 * Date on 2018/12/24.
 */
public abstract class BottomItemDelegate extends MavoDelegate implements View.OnKeyListener {


    private long mExitTime = 0;
    private static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();

        final  View rootView = getView();
        if (rootView != null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis() - mExitTime) > mExitTime){
                Toast.makeText(getContext(), "双击退出"+ getString(R.string.app_name),Toast.LENGTH_SHORT);
                mExitTime = System.currentTimeMillis();
            }else {
                _mActivity.finish();
                if (mExitTime != 0){
                    mExitTime = 0;
                }
            }
            return true;
        }

        return false;
    }
}
