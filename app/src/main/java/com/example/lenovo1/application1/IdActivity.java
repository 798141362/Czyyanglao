package com.example.lenovo1.application1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IdActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mEtName,mEtIdcard,mEtTel,mEtBorndate,mEtAge,mEtLive,mEtBlood;
    private Button mBtnSave,mBtnShow;
    private TextView mTvName,mTvIdcard,mTvTel,mTvBorndate,mTvAge,mTvLive,mTvBlood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_id);

        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);

        mEtName = (EditText) findViewById(R.id.et_name);
        mEtIdcard = (EditText) findViewById(R.id.et_idcard);
        mEtTel = (EditText) findViewById(R.id.et_tel);
        mEtBorndate = (EditText) findViewById(R.id.et_borndate);
        mEtAge = (EditText) findViewById(R.id.et_age);
        mEtLive = (EditText) findViewById(R.id.et_live);
        mEtBlood = (EditText) findViewById(R.id.et_blood);

        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvIdcard = (TextView) findViewById(R.id.tv_idcard);
        mTvTel = (TextView) findViewById(R.id.tv_tel);
        mTvBorndate = (TextView) findViewById(R.id.tv_borndate);
        mTvAge = (TextView) findViewById(R.id.tv_age);
        mTvLive = (TextView) findViewById(R.id.tv_live);
        mTvBlood = (TextView) findViewById(R.id.tv_blood);

        mSharedPreferences = getSharedPreferences("Iddata",MODE_PRIVATE); //data是文件名称
        mEditor = mSharedPreferences.edit();


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putString("name",mEtName.getText().toString());//cun
                mEditor.putString("idcard",mEtIdcard.getText().toString());
                mEditor.putString("tel",mEtTel.getText().toString());
                mEditor.putString("borndate",mEtBorndate.getText().toString());
                mEditor.putString("age",mEtAge.getText().toString());
                mEditor.putString("live",mEtLive.getText().toString());
                mEditor.putString("blood",mEtBlood.getText().toString());
                mEditor.apply();//tijiao commit同步储存 apply是异步先变再存储到手机内存
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvName.setText(mSharedPreferences.getString("name",""));//du
                mTvIdcard.setText(mSharedPreferences.getString("idcard",""));
                mTvTel.setText(mSharedPreferences.getString("tel",""));
                mTvBorndate.setText(mSharedPreferences.getString("borndate",""));
                mTvAge.setText(mSharedPreferences.getString("age",""));
                mTvLive.setText(mSharedPreferences.getString("live",""));
                mTvBlood.setText(mSharedPreferences.getString("blood",""));


            }
        });

    }
}
