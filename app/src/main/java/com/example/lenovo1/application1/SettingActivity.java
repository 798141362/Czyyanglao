package com.example.lenovo1.application1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;




public class SettingActivity extends AppCompatActivity {
    private Button mBtnApp;
    private Button mBtnAgreement;
    private Button mBtnSuggestion;
    private Button mBtnAccount;
    private Button mBtnData;
    private Button mBtnSafety;
    private Button mBtnCache;
    private Button mBtnHelp;
    private Button mBtnCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mBtnApp = (Button) findViewById(R.id.btn_app);
        mBtnAgreement = (Button) findViewById(R.id.btn_agreement);
        mBtnSuggestion = (Button) findViewById(R.id.btn_suggestion);
        mBtnAccount = (Button) findViewById(R.id.btn_account);
        mBtnData = (Button) findViewById(R.id.btn_data);
        mBtnSafety = (Button) findViewById(R.id.btn_safety);

        mBtnHelp = (Button) findViewById(R.id.btn_help);
        mBtnCommon = (Button) findViewById(R.id.btn_common);
        setListeners();

        mBtnCache = (Button) findViewById(R.id.btn_cache);
        mBtnCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);    //样式1(默认）代码   builder建造者模式
                builder.setTitle("清除缓存");                                                    //给builder设置tittle方法实现
                builder.setMessage("是否确定清除缓存？");                                            //给builder设置中间显示mes（也就是文本）方法实现 也可以这样实现代码  builder.setTitle("请回答").setMessage("你举得如何？");
                builder.setIcon(R.drawable.cache);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CleanMessageUtil.clearAllCache(getApplicationContext());

                        Toast.makeText(SettingActivity.this,"清除成功",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SettingActivity.this,"取消成功",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

    private void setListeners() {
        OnClick onClicklik = new OnClick();
        mBtnApp.setOnClickListener(onClicklik);
        mBtnAgreement.setOnClickListener(onClicklik);
        mBtnSuggestion.setOnClickListener(onClicklik);
        mBtnAccount.setOnClickListener(onClicklik);
        mBtnData.setOnClickListener(onClicklik);
        mBtnSafety.setOnClickListener(onClicklik);

        mBtnHelp.setOnClickListener(onClicklik);
        mBtnCommon.setOnClickListener(onClicklik);

    }

    private class OnClick implements View.OnClickListener {//上面的onclick实现了onclickListener接口

        //简写设置监听事件的代码  设置一个监听onclick类
        @Override
        public void onClick(View v) {
            Intent intent = null;//初始化一个intent
            switch (v.getId()) { //根据v的id判断点击哪个控件
                case R.id.btn_app:
                    intent = new Intent(SettingActivity.this, AppActivity.class);
                    break;
                case R.id.btn_agreement:
                    intent = new Intent(SettingActivity.this, AgreementActivity.class);
                    break;
                case R.id.btn_suggestion:
                    intent = new Intent(SettingActivity.this, FeedbackActivity.class);
                    break;
                case R.id.btn_account:
                    intent = new Intent(SettingActivity.this, AccountActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(SettingActivity.this, DataActivity.class);
                    break;
                case R.id.btn_safety:
                    intent = new Intent(SettingActivity.this, SafetyActivity.class);
                    break;
                case R.id.btn_help:
                    intent = new Intent(SettingActivity.this, HelpActivity.class);
                    break;
                case R.id.btn_common:
                    intent = new Intent(SettingActivity.this, CommonActivity.class);
                    break;

            }
            startActivity(intent);



        }
    }
}
