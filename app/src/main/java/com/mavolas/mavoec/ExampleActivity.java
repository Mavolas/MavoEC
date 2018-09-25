package com.mavolas.mavoec;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mavolas.mavo.activitys.ProxyActivity;
import com.mavolas.mavo.delegates.MavoDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public MavoDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
