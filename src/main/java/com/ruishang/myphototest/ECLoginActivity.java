package com.ruishang.myphototest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

/**
 * Created by Raymo on 2018/3/17.
 */

public class ECLoginActivity extends AppCompatActivity{

    private EditText mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mUsernameView = (EditText) findViewById(R.id.ec_edit_username);
        mPasswordView = (EditText) findViewById(R.id.ec_edit_password);


        findViewById(R.id.ec_btn_sign_up).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signup();

            }
        });


        findViewById(R.id.ec_btn_sign_in).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signin();

            }
        });
    }
    private void signup(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    EMClient.getInstance().createAccount(mUsernameView.getText().toString().trim(), mPasswordView.getText().toString().trim());
                    Log.i("shuaHIT", "注册成功 ");
                }catch (HyphenateException e){
                    e.printStackTrace();
                    Log.i("shuaHIT", "注册失败 " + e.getErrorCode() + ", " + e.getMessage());
                }

            }
        }).start();
    }

    private void signin(){
        EMClient.getInstance().login(mUsernameView.getText().toString().trim(), mPasswordView.getText().toString().trim(), new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(ECLoginActivity.this, ECMainActivity.class));
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.e("shuaHIT", "登陆失败" + i + ", " + s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
