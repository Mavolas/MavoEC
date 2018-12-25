package com.mavolas.mavo.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.mavolas.mavo.delegates.MavoDelegate;
import com.mavolas.mavo.ec.R;
import com.mavolas.mavo.ec.R2;
import com.mavolas.mavo.ec.main.MavoBottomDelegate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 宋棋安
 * on 2018/10/6.
 */
public class SignInDelegate extends MavoDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){

        if ( checkForm() ){

            startWithPop(new MavoBottomDelegate());

        }
    }
    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat(){

    }

    @OnClick(R2.id.tv_link_sign_up)
    void OnclickLink(){
        start( new SignUpDelegate() );
    }

    private boolean checkForm(){

        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();


        boolean isPass = true;


        if ( email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher( email ).matches() ){
            mEmail.setError( "错误的邮箱格式" );
            isPass = false;
        }else {
            mEmail.setError( null );
        }

        if ( password.isEmpty() || password.length() < 6){
            mPassword.setError( "请填写至少6未密码" );
            isPass = false;
        }else {
            mPassword.setError( null );
        }


        return isPass;
    }



    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
