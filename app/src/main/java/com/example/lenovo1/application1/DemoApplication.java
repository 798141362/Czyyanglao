package com.example.lenovo1.application1;

/**
 * Created by lenovo1 on 2019/3/21.
 */


import android.app.Application;
import android.content.Context;



/**
 * Created by tomchen on 2017/7/3.
 */

public class DemoApplication extends Application {

    /**
     * 请配置appkey、appsecret
     */
    private static final String APP_KEY = "25850212";

    private static final String APP_SECRET = "3eeea801cd4688b2f60c45370369ebb9 ";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }



}
