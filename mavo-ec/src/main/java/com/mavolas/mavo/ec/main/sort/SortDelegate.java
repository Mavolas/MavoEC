package com.mavolas.mavo.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mavolas.mavo.bottom.BottomItemDelegate;
import com.mavolas.mavo.delegates.BaseDelegate;
import com.mavolas.mavo.ec.R;

/**
 * Author by Andy
 * Date on 2018/12/25.
 */
public class SortDelegate  extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
