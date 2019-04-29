package com.example.lenovo1.application1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class HospitalActivity extends AppCompatActivity {
    private Button mBtnGxuyy;
    private Button mBtnBhrmyy;
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
        setContentView(R.layout.activity_hospital);
        mBtnGxuyy = (Button) findViewById(R.id.btn_gxuyy);
        mBtnBhrmyy = (Button) findViewById(R.id.btn_bhrmyy);
        setListeners();
    }
    private void setListeners() {
        OnClick onClicklik = new OnClick();
        mBtnGxuyy.setOnClickListener(onClicklik);
        mBtnBhrmyy.setOnClickListener(onClicklik);
    }
    private class OnClick implements View.OnClickListener {//上面的onclick实现了onclickListener接口

        //简写设置监听事件的代码  设置一个监听onclick类
        @Override
        public void onClick(View v) {
            Intent intent = null;//初始化一个intent
            switch (v.getId()) { //根据v的id判断点击哪个控件
                case R.id.btn_gxuyy:
                    intent = new Intent(HospitalActivity.this,GxuYYActivity.class);
                    break;
                case R.id.btn_bhrmyy:
                    intent = new Intent(HospitalActivity.this,BhrmYYActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
