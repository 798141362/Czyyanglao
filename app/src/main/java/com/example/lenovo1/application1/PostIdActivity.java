package com.example.lenovo1.application1;


import android.graphics.Color;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.message.BasicNameValuePair;


public class PostIdActivity extends AppCompatActivity {

    //private SharedPreferences mSharedPreferences;这两个是shared Preferences数据库的
    //private SharedPreferences.Editor mEditor;

    private EditText mEtName, mEtIdcard, mEtSex, mEtElderTel, mEtNation, mEtBorndate, mEtEldertype, mEtElderage, mEtElderlive, mEtElderagency, mEtEmercontact, mEtEmertel, mEtServicetype, mEtServicestate;
    private TextView mTvName, mTvIdcard,mTtSex, mTvElderTel, mTvNation, mTvBorndate, mTvEldertype, mTvElderage, mTvElderlive, mTvElderagency, mTvEmercontact, mTvEmertel, mTvServicetype, mTvServicestate;
    private Button mBtnSave, mBtnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_postid);

        mEtName = (EditText) findViewById(R.id.et_name);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mEtIdcard = (EditText) findViewById(R.id.et_idcard);
        mTvIdcard = (TextView) findViewById(R.id.tv_idcard);
        mEtSex = (EditText) findViewById(R.id.et_sex);
        mTtSex = (TextView) findViewById(R.id.tv_sex);
        mEtElderTel = (EditText) findViewById(R.id.et_eldertel);
        mTvElderTel = (TextView) findViewById(R.id.tv_eldertel);


        mEtNation = (EditText) findViewById(R.id.et_nation);
        mTvNation = (TextView) findViewById(R.id.tv_nation);
        mEtBorndate = (EditText) findViewById(R.id.et_borndate);
        mTvBorndate = (TextView) findViewById(R.id.tv_borndate);
        mEtEldertype = (EditText) findViewById(R.id.et_eldertype);
        mTvEldertype = (TextView) findViewById(R.id.tv_eldertype);
        mEtElderage = (EditText) findViewById(R.id.et_elderage);
        mTvElderage = (TextView) findViewById(R.id.tv_elderage);

        mEtElderlive = (EditText) findViewById(R.id.et_elderlive);
        mTvElderlive = (TextView) findViewById(R.id.tv_elderlive);
        mEtElderagency = (EditText) findViewById(R.id.et_elderagency);
        mTvElderagency = (TextView) findViewById(R.id.tv_elderagency);
        mEtEmercontact = (EditText) findViewById(R.id.et_emercontact);
        mTvEmercontact = (TextView) findViewById(R.id.tv_emercontact);
        mEtEmertel = (EditText) findViewById(R.id.et_emertel);
        mTvEmertel = (TextView) findViewById(R.id.tv_emertel);
        mEtServicetype = (EditText) findViewById(R.id.et_servicetype);
        mTvServicetype = (TextView) findViewById(R.id.tv_servicetype);
        mEtServicestate = (EditText) findViewById(R.id.et_servicestate);
        mTvServicestate = (TextView) findViewById(R.id.tv_servicestate);

        mBtnShow = (Button) findViewById(R.id.btn_show);

        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEtName.getText().toString();
                String idcard = mEtIdcard.getText().toString();
                String sex = mEtSex.getText().toString();
                String eldertel = mEtElderTel.getText().toString();
                String nation = mEtNation.getText().toString();
                String borndate = mEtBorndate.getText().toString();
                String eldertype = mEtEldertype.getText().toString();
                String elderage = mEtElderage.getText().toString();
                String elderlive = mEtElderlive.getText().toString();
                String elderagency = mEtElderagency.getText().toString();
                String emercontact = mEtEmercontact.getText().toString();
                String emertel = mEtEmertel.getText().toString();
                String servicetype = mEtServicetype.getText().toString();
                String servicestate = mEtServicestate.getText().toString();

                //使用POST方法向服务器发送数据
                PostThread postThread = new PostThread(name, idcard, sex,eldertel, nation, borndate, eldertype, elderage, elderlive,elderagency ,emercontact, emertel, servicetype,servicestate);
                postThread.start();
            }
        });
    }

    //子线程：通过GET方法向服务器发送用户名、密码的信息
    class PostThread extends Thread {

        String name;
        String idcard;
        String sex;
        String eldertel;
        String nation;
        String borndate;
        String eldertype;
        String elderage;
        String elderlive;
        String elderagency;
        String emercontact;
        String emertel;
        String servicetype;
        String servicestate;
        public PostThread(String name, String idcard,  String sex,String eldertel, String nation, String borndate, String eldertype, String elderage, String elderlive,String elderagency, String emercontact, String emertel, String servicetype, String servicestate) {
            this.name = name;
            this.idcard = idcard;
            this.sex = sex;
            this.eldertel = eldertel;
            this.nation = nation;
            this.borndate = borndate;
            this.eldertype = eldertype;
            this.elderage = elderage;
            this.elderlive = elderlive;
            this.elderagency = elderagency;
            this.emercontact = emercontact;
            this.emertel = emertel;
            this.servicetype = servicetype;
            this.servicestate = servicestate;
        }


        @Override

        public void run() {
            HttpClient client = HttpClientBuilder.create().build();
            String url = "http://47.102.218.76:88/api/AddElder";
            //第二步：生成使用POST方法的请求对象
            HttpPost httpPost = new HttpPost(url);
            //NameValuePair对象代表了一个需要发往服务器的键值对
            NameValuePair pair1 = new BasicNameValuePair("name", name);
            NameValuePair pair2 = new BasicNameValuePair("idcard", idcard);
            NameValuePair pair3 = new BasicNameValuePair("sex", sex);
            NameValuePair pair4 = new BasicNameValuePair("eldertel", eldertel);
            NameValuePair pair5 = new BasicNameValuePair("nation", nation);
            NameValuePair pair6 = new BasicNameValuePair("borndate", borndate);
            NameValuePair pair7 = new BasicNameValuePair("eldertype", eldertype);
            NameValuePair pair8 = new BasicNameValuePair("elderage", elderage);
            NameValuePair pair9 = new BasicNameValuePair("elderlive", elderlive);
            NameValuePair pair10 = new BasicNameValuePair("elderagency", elderagency);
            NameValuePair pair11 = new BasicNameValuePair("emercontact", emercontact);
            NameValuePair pair12 = new BasicNameValuePair("emertel", emertel);
            NameValuePair pair13 = new BasicNameValuePair("servicetype", servicetype);
            NameValuePair pair14 = new BasicNameValuePair("servicestate", servicestate);
            //将准备好的键值对对象放置在一个List当中
            ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(pair1);
            pairs.add(pair2);
            pairs.add(pair3);
            pairs.add(pair4);
            pairs.add(pair5);
            pairs.add(pair6);
            pairs.add(pair7);
            pairs.add(pair8);
            pairs.add(pair9);
            pairs.add(pair10);
            pairs.add(pair11);
            pairs.add(pair12);
            pairs.add(pair13);
            pairs.add(pair14);
            try {
                //创建代表请求体的对象（注意，是请求体）
                HttpEntity requestEntity = new UrlEncodedFormEntity(pairs);
                //将请求体放置在请求对象当中
                httpPost.setEntity(requestEntity);
                //执行请求对象
                try {
                    //第三步：执行请求对象，获取服务器发还的相应对象
                    HttpResponse response = client.execute(httpPost);
                    //第四步：检查相应的状态是否正常：检查状态码的值是200表示正常
                    if (response.getStatusLine().getStatusCode() == 200) {
                        //第五步：从相应对象当中取出数据，放到entity当中
                        HttpEntity entity = response.getEntity();
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(entity.getContent()));
                        String result = reader.readLine();
                        Log.d("HTTP", "POST:" + result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}