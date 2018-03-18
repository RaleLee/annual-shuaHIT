package com.ruishang.myphototest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.easeui.ui.EaseChatFragment;

/**
 * Created by Raymo on 2018/3/17.
 */

public class ECChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //直接使用封装好的聊天界面
        EaseChatFragment chatFragment;
        chatFragment = new EaseChatFragment();

        //将参数传递给聊天界面
        chatFragment.setArguments(getIntent().getExtras());

        // 加载封装的聊天界面Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.ec_layout_input, chatFragment).commit();
    }
}
