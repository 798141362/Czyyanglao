package com.example.lenovo1.application1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HealthActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private HealthMainViewPagerAdapter pagerAdapter;


    private TextView dateText;

    private int healthPagerPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_health);
        GlobalUtil.getInstance().setContext(getApplicationContext());
        GlobalUtil.getInstance().healthActivity = this;
        //getSupportActionBar().setElevation(0);//修改Action bar跟下布局中间的阴影线



        dateText = (TextView) findViewById(R.id.date_text);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pagerAdapter = new HealthMainViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(pagerAdapter.getLastIndex());//解决一打开便是当前日期的方法 防止反着滑动

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthActivity.this,AddRecordActivity.class);
                startActivityForResult(intent,1);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        pagerAdapter.reload();
        updateHeader();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        healthPagerPosition = position;
        updateHeader();

    }

    public  void updateHeader(){


        String date = pagerAdapter.getDateStr(healthPagerPosition);
        dateText.setText(DataUtil.getWeekDay(date));

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}