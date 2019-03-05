package com.example.lenovo1.application1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnLogin;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnRegister = (Button) findViewById(R.id.btn_register);

        setListeners();
    }
    private void setListeners(){
        OnClick onClicklik = new OnClick();
        mBtnLogin.setOnClickListener(onClicklik);
        mBtnRegister.setOnClickListener(onClicklik);

}
    private class OnClick implements View.OnClickListener{//上面的onclick实现了onclickListener接口
        //简写设置监听事件的代码  设置一个监听onclick类
        @Override
        public void onClick(View v) {
            Intent intent = null;//初始化一个intent
            switch (v.getId()){ //根据v的id判断点击哪个控件
                case R.id.btn_login:
                    intent = new Intent(LoginActivity.this, HomeActivity.class);
                    break;
                case R.id.btn_register:
                    intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
