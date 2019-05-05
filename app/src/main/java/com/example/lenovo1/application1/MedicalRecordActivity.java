package com.example.lenovo1.application1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicalRecordActivity extends AppCompatActivity {


    private Button mBtnMRecordAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);



        GlobalUtil.getInstance().setContext(getApplicationContext());
        GlobalUtil.getInstance().medicalRecordActivity = this;


        mBtnMRecordAdd = (Button) findViewById(R.id.btn_add);


    }

}
