package com.ruishang.myphototest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;

/**
 * Created by Raymo on 2018/3/17.
 */

public class ECMainActivity extends AppCompatActivity{

    private EditText mChatIDView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChatIDView = (EditText) findViewById(R.id.ec_edit_chat_id);

        findViewById(R.id.ec_btn_start_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startchat();
            }
        });
        findViewById(R.id.ec_btn_sign_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });
    }

    private void startchat(){
        Intent intent = new Intent(ECMainActivity.this, ECChatActivity.class);
        intent.putExtra(EaseConstant.EXTRA_USER_ID, mChatIDView.getText().toString().trim());
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
        startActivity(intent);
    }

    private void signout(){
        EMClient.getInstance().logout(false, new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(ECMainActivity.this, ECLoginActivity.class));
            }

            @Override
            public void onError(int i, String s) {
                Log.e("shuaHIT", "退出登录失败" + i + ", " + s);
                finish();
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
