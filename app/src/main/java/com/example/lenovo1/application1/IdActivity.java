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

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mEtUserName,mEtUserId,mEtUserPhone,mEtUserAddress;
    private TextView mTvUserName,mTvUserId,mTvUserPhone,mTvUserAddress;
    private Button mBtnSave,mBtnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);

        }
        setContentView(R.layout.activity_id);

        mEtUserName = (EditText) findViewById(R.id.et_username);
        mEtUserId = (EditText) findViewById(R.id.et_userid);
        mEtUserPhone = (EditText) findViewById(R.id.et_userphone);
        mEtUserAddress = (EditText) findViewById(R.id.et_useraddress);
        mTvUserName = (TextView) findViewById(R.id.tv_username);
        mTvUserId = (TextView) findViewById(R.id.tv_userid);
        mTvUserPhone = (TextView) findViewById(R.id.tv_userphone);
        mTvUserAddress = (TextView) findViewById(R.id.tv_useraddress);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);

        mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE); //data是文件名称
        mEditor = mSharedPreferences.edit();

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putString("username",mEtUserName.getText().toString());//cun
                mEditor.putString("userid",mEtUserId.getText().toString());
                mEditor.putString("userphone",mEtUserPhone.getText().toString());
                mEditor.putString("useraddress",mEtUserAddress.getText().toString());
                mEditor.apply();//tijiao commit同步储存 apply是异步先变再存储到手机内存

            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvUserName.setText(mSharedPreferences.getString("username",""));//du
                mTvUserId.setText(mSharedPreferences.getString("userid",""));
                mTvUserPhone.setText(mSharedPreferences.getString("userphone",""));
                mTvUserAddress.setText(mSharedPreferences.getString("useraddress",""));
            }
        });
    }
}
