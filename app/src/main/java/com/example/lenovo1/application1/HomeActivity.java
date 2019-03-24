package com.example.lenovo1.application1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button mBtnHealth;
    private Button mBtnNote;
    private Button mBtnMedicine;
    private Button mBtnSetting;
    private Button mBtnLocal;
    private Button mBtnId;
    private Button mBtnCellphone;
    private Button mBtnHospital;
    private Button mBtnWebview1;
    private Button mBtnWebview2;
    private Button mBtnWebview3;
    private Button mBtnWebview4;


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

        setContentView(R.layout.activity_home);
        mBtnHealth = (Button) findViewById(R.id.btn_health);
        mBtnNote = (Button) findViewById(R.id.btn_note);
        mBtnMedicine = (Button) findViewById(R.id.btn_medicine);
        mBtnSetting = (Button) findViewById(R.id.btn_setting);
        mBtnLocal = (Button) findViewById(R.id.btn_local);
        mBtnId = (Button) findViewById(R.id.btn_id);
        mBtnHospital = (Button) findViewById(R.id.btn_hospital);
        mBtnWebview1 = (Button) findViewById(R.id.btn_webview1);
        mBtnWebview2 = (Button) findViewById(R.id.btn_webview2);
        mBtnWebview3 = (Button) findViewById(R.id.btn_webview3);
        mBtnWebview4 = (Button) findViewById(R.id.btn_webview4);
        mBtnCellphone = (Button) findViewById(R.id.btn_cellphone);
        setListeners();
        mBtnCellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialphoneNumber("110");
            }
        });
    }



    private void setListeners() {
        OnClick onClicklik = new OnClick();
        mBtnHealth.setOnClickListener(onClicklik);
        mBtnNote.setOnClickListener(onClicklik);
        mBtnMedicine.setOnClickListener(onClicklik);
        mBtnSetting.setOnClickListener(onClicklik);
        mBtnLocal.setOnClickListener(onClicklik);
        mBtnId.setOnClickListener(onClicklik);
        mBtnCellphone.setOnClickListener(onClicklik);
        mBtnHospital.setOnClickListener(onClicklik);
        mBtnWebview1.setOnClickListener(onClicklik);
        mBtnWebview2.setOnClickListener(onClicklik);
        mBtnWebview3.setOnClickListener(onClicklik);
        mBtnWebview4.setOnClickListener(onClicklik);
    }
    private void dialphoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private class OnClick implements View.OnClickListener {//上面的onclick实现了onclickListener接口

        //简写设置监听事件的代码  设置一个监听onclick类
        @Override
        public void onClick(View v) {
            Intent intent = null;//初始化一个intent
            switch (v.getId()) { //根据v的id判断点击哪个控件
                case R.id.btn_health:
                    intent = new Intent(HomeActivity.this, HealthActivity.class);
                    break;
                case R.id.btn_note:
                    intent = new Intent(HomeActivity.this, NoteActivity.class);
                    break;
                case R.id.btn_medicine:
                    intent = new Intent(HomeActivity.this, MedicineActivity.class);
                    break;
                case R.id.btn_setting:
                    intent = new Intent(HomeActivity.this, SettingActivity.class);
                    break;
                case R.id.btn_local:
                    intent = new Intent(HomeActivity.this, LocalActivity.class);
                    break;
                case R.id.btn_id:
                    intent = new Intent(HomeActivity.this, IdActivity.class);
                    break;
                case R.id.btn_hospital:
                    intent = new Intent(HomeActivity.this, HospitalActivity.class);
                    break;
                case R.id.btn_webview1:
                    intent = new Intent(HomeActivity.this, Webview1Activity.class);
                    break;
                case R.id.btn_webview2:
                    intent = new Intent(HomeActivity.this, Webview2Activity.class);
                    break;
                case R.id.btn_webview3:
                    intent = new Intent(HomeActivity.this, Webview3Activity.class);
                    break;
                case R.id.btn_webview4:
                    intent = new Intent(HomeActivity.this, Webview4Activity.class);
                    break;
                case R.id.btn_cellphone:
                    dialphoneNumber("110");
            }
            startActivity(intent);
        }
    }
}