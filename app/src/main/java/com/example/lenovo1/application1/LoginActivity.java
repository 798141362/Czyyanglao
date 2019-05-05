
package com.example.lenovo1.application1;


import android.content.Intent;
import android.os.Bundle;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import android.app.Activity;

import android.os.Bundle;

import android.os.Handler;

import android.os.Message;

import android.util.Log;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;


import java.io.InputStream;

import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URLEncoder;

import okhttp3.Callback;

import okhttp3.MultipartBody;

import okhttp3.OkHttpClient;


import java.io.InputStream;

import java.net.HttpURLConnection;

import java.net.URL;

import java.net.URLEncoder;


public class LoginActivity extends AppCompatActivity {

    private EditText mEtSername, mEtPsw;
    private Button mBtnRegiste;
    private Button mBtnLogin;
    private final OkHttpClient client = new OkHttpClient();


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        //获得布局上的用户名输入框和密码输入框

        mEtSername = (EditText) findViewById(R.id.et_username);

        mEtPsw = (EditText) findViewById(R.id.et_password);
        mBtnRegiste = (Button) findViewById(R.id.btn_register);
        mBtnRegiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获得用户输入的用户名和密码

                String sername = mEtSername.getText().toString();

                String psw = mEtPsw.getText().toString();


                //设置地址

                //提交的数据需要经过Url编码,英文和数字编码后不变

                final String path = "http://47.102.218.76:88/api/Login" +

                        "?username=" + URLEncoder.encode(sername) + "&" + "password=" + psw;


                Log.d("LoginActivity", path);


                //创建一个子线程

                Thread thread = new Thread() {


                    //执行子线程

                    @Override

                    public void run() {

                        Looper.prepare();

                        try {

                            //将地址封装成Url

                            URL url = new URL(path);

                            Log.d("LoginActivity", "Url");


                            //获取连接对象,此时未建立连接

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                            Log.d("LoginActivity", "Connection");


                            //设置请求方式为Get请求

                            conn.setRequestMethod("GET");

                            Log.d("LoginActivity", "Get");


                            //设置连接超时

                            conn.setConnectTimeout(5000);

                            Log.d("LoginActivity", "Timeout1");


                            //设置读取超时

                            conn.setReadTimeout(5000);

                            Log.d("LoginActivity", "Timeout2");


                            int code = conn.getResponseCode();

                            Log.d("LoginActivity", "code=" + code);


                            //如果请求成功

                            if (conn.getResponseCode() == 200) {


                                //获得输入流

                                InputStream is = conn.getInputStream();

                                Log.d("LoginActivity", "InputStream");


                                //获得输入流中的文本

                                String text = Util.getTextFromStream(is);


                                //创建消息对象

                                Message message = handler.obtainMessage();


                                //实现消息对象携带的数据

                                message.obj = text;


                                //将消息发送到主线程的消息队列

                                handler.sendMessage(message);
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                LoginActivity.this.finish();
                            }

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    }

                };


                //启动子线程

                thread.start();

            }
        });
    }


    //创建Handler对象,用于在主线程中接收并处理由子线程

    //发送过来的消息

    Handler handler = new Handler() {


        //在主线程中处理由子线程发送过来的消息

        public void handleMessage(android.os.Message msg) {


            //获得消息中携带的数据

            //消息携带的是用户是否登录成功的信息

            String text = (String) msg.obj;


            //创建吐司对话框,提示用户是否登录成功

            Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();

        }

    };


    //登录


}