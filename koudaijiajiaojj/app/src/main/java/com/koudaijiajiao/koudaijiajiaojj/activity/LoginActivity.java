package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.koudaijiajiao.koudaijiajiaojj.R;

/**
 * Created by killandy on 2016/10/27.
 */
//登录
public class LoginActivity extends Activity{
    Button login;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AVUser.loginByMobilePhoneNumberInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback<AVUser>() {
                    @Override
                    public void done(AVUser avUser, AVException e) {
                        if (e==null) {

                            Intent intent = new Intent(LoginActivity.this, IdentifyActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"登录失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private void initView() {
        login= (Button) findViewById(R.id.btn_login_login);
        username= (EditText) findViewById(R.id.edit_login_username);
        password= (EditText) findViewById(R.id.edit_login_password);
    }
}
