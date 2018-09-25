package com.mavolas.mavoec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mavolas.mavo.delegates.MavoDelegate;

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

    }
}
