package com.example.lenovo1.application1;




import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;


public class NoteActivity extends Activity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mEtNote,mEtNote1,mEtNote2,mEtNote3,mEtNote4,mEtNote5;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);



        mEtNote = (EditText) findViewById(R.id.et_note);
        mEtNote1 = (EditText) findViewById(R.id.et_note1);
        mEtNote2 = (EditText) findViewById(R.id.et_note2);
        mEtNote3 = (EditText) findViewById(R.id.et_note3);
        mEtNote4 = (EditText) findViewById(R.id.et_note4);
        mEtNote5 = (EditText) findViewById(R.id.et_note5);



        mSharedPreferences = getSharedPreferences("Notedata",MODE_PRIVATE); //data是文件名称
        mEditor = mSharedPreferences.edit();

        save();

        show();

    }
    private void save(){
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putString("note",mEtNote.getText().toString());//cun
                mEditor.putString("note1",mEtNote1.getText().toString());
                mEditor.putString("note2",mEtNote2.getText().toString());
                mEditor.putString("note3",mEtNote3.getText().toString());
                mEditor.putString("note4",mEtNote4.getText().toString());
                mEditor.putString("note5",mEtNote5.getText().toString());
                mEditor.apply();//tijiao commit同步储存 apply是异步先变再存储到手机内存
            }
        });
    }
    private void show(){
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtNote.setText(mSharedPreferences.getString("note",""));//du
                mEtNote1.setText(mSharedPreferences.getString("note1",""));
                mEtNote2.setText(mSharedPreferences.getString("note2",""));
                mEtNote3.setText(mSharedPreferences.getString("note3",""));
                mEtNote4.setText(mSharedPreferences.getString("note4",""));
                mEtNote5.setText(mSharedPreferences.getString("note5",""));
            }
        });
    }

}