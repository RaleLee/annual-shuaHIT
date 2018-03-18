package com.ruishang.myphototest;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseUI;

/**
 * Created by Raymo on 2018/3/17.
 */

public class ECAppication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();


        EaseUI.getInstance().init(this, null);
        EMClient.getInstance().setDebugMode(true);


    }
}
