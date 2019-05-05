package com.example.lenovo1.application1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RegisterActivity extends AppCompatActivity {
    private EditText mEtSername, mEtPsw, mEtPsw1, mEtEmail, mEtLive;
    private Button mBtnRegiste;
    private List<UserBean> list;

    private String sername, psw;

    final OkHttpClient client = new OkHttpClient();


    private Handler mHandler = new Handler() {

        @Override

        public void handleMessage(Message msg) {
            super.handleMessage(msg);



            }




    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEtSername = (EditText) findViewById(R.id.et_sername);

        mEtPsw = (EditText) findViewById(R.id.et_psw);

        mEtPsw1 = (EditText) findViewById(R.id.et_psw1);

        mEtEmail = (EditText) findViewById(R.id.et_Email);
        mEtLive = (EditText) findViewById(R.id.et_live);
        mBtnRegiste = (Button) findViewById(R.id.btn_registe);

        mBtnRegiste.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                //获取相关参数
                String sername = mEtSername.getText().toString();
                String psw = mEtPsw.getText().toString();
                String psw1 = mEtPsw1.getText().toString();
                String Email = mEtEmail.getText().toString();
                String Live = mEtLive.getText().toString();

                if (TextUtils.isEmpty(sername)) {
                    //用户名为空
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(psw1)) {
                    Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
                } else if (!psw.equals(psw1)) {
                    Toast.makeText(RegisterActivity.this, "两次密码不一样，请验证", Toast.LENGTH_SHORT).show();

                }
                postRequest(sername, psw, Email, Live); //通过okhttp发起post请求
            }
        });
    }

    private void postRequest(String sername, String psw, String Email, String Live) {

        //建立请求表单，添加上传服务器的参数

        RequestBody formBody = new FormBody.Builder()

                .add("sername", sername)
                .add("psw", psw)
                .add("Email", Email)
                .add("Live", Live)
                .build();

        //发起请求

        final Request request = new Request.Builder()

                .url("http://47.102.218.76:88/api/register")

                .post(formBody)

                .build();

        //新建一个线程，用于得到服务器响应的参数

        new Thread(new Runnable() {

            @Override

            public void run() {

                Response response = null;

                try {

                    //回调

                    response = client.newCall(request).execute();

                    if (response.isSuccessful()) {

                        //将服务器响应的参数response.body().string())发送到hanlder中，并更新ui

                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();
                       //注册成功跳转到登录页面
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        RegisterActivity.this.finish();

                    } else {

                        throw new IOException("Unexpected code:" + response);

                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }).start();


    }
}
