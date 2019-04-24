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
import android.widget.ImageButton;
import android.widget.TextView;

public class IdActivity extends AppCompatActivity {

    //private SharedPreferences mSharedPreferences;这两个是shared Preferences数据库的
    //private SharedPreferences.Editor mEditor;

    private EditText mEtName,mEtIdcard,mEtElderTel,mEtMarriage,mEtNation,mEtBorndate,mEtEldertype ,mEtElderage,mEtElderlive,mEtSecurity,mEtChronic,mEtBtype,mEtElderagency;
    private TextView mTvName,mTvIdcard,mTvElderTel,mTvMarriage,mTvNation,mTvBorndate,mTvEldertype ,mTvElderage ,mTvElderlive ,mTvSecurity,mTvChronic,mTvBtype,mTvElderagency;
    private Button mBtnSave,mBtnShow;
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
        setContentView(R.layout.activity_id);

      mEtName = (EditText) findViewById(R.id.et_name);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mEtIdcard = (EditText) findViewById(R.id.et_idcard);
        mTvIdcard = (TextView) findViewById(R.id.tv_idcard);
       mEtElderTel = (EditText) findViewById(R.id.et_eldertel);
        mTvElderTel = (TextView) findViewById(R.id.tv_eldertel);
       mEtMarriage = (EditText) findViewById(R.id.et_marriage);
        mTvMarriage = (TextView) findViewById(R.id.tv_marriage);


        mEtNation = (EditText) findViewById(R.id.et_nation);
        mTvNation = (TextView) findViewById(R.id.tv_nation);
        mEtBorndate = (EditText) findViewById(R.id.et_borndate);
        mTvBorndate= (TextView) findViewById(R.id.tv_borndate);
        mEtEldertype = (EditText) findViewById(R.id.et_eldertype);
        mTvEldertype = (TextView) findViewById(R.id.tv_eldertype);
        mEtElderage = (EditText) findViewById(R.id.et_elderage);
        mTvElderage = (TextView) findViewById(R.id.tv_elderage);

        mEtElderlive = (EditText) findViewById(R.id.et_elderlive);
        mTvElderlive = (TextView) findViewById(R.id.tv_elderlive);
        mEtElderagency = (EditText) findViewById(R.id.et_elderagency);
        mTvElderagency= (TextView) findViewById(R.id.tv_elderagency);
        mEtSecurity = (EditText) findViewById(R.id.et_security);
        mTvSecurity = (TextView) findViewById(R.id.tv_security);
        mEtChronic = (EditText) findViewById(R.id.et_chronic);
        mTvChronic= (TextView) findViewById(R.id.tv_chronic);
        mEtBtype = (EditText) findViewById(R.id.et_btype);
        mTvBtype = (TextView) findViewById(R.id.tv_btype);




       mBtnSave = (Button) findViewById(R.id.btn_save);
       mBtnShow = (Button) findViewById(R.id.btn_show);


    }
}
