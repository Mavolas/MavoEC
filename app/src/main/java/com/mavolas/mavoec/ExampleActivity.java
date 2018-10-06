package com.mavolas.mavoec;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mavolas.mavo.activitys.ProxyActivity;
import com.mavolas.mavo.delegates.MavoDelegate;
import com.mavolas.mavo.ec.launcher.LauncherDelegate;
import com.mavolas.mavo.ec.launcher.LauncherScrollDelegate;
import com.mavolas.mavo.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        final ActionBar actionBar = getSupportActionBar();
        if ( actionBar != null ){
            actionBar.hide();
        }
    }

    @Override
    public MavoDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
