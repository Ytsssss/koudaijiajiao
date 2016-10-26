package com.example.a99517.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.dd.CircularProgressButton;

/**
 * Created by 99517 on 2016/6/11.
 */
public class LogAcitivity extends Activity{
    EditText account;
    EditText password;
    CircularProgressButton login;
    TextView forget;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this, "UnBdno1sc2kQ72tnvlgP3ti8-gzGzoHsz", "gU9hPU1tgau5w0l6JUNnI2Nj");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        account= (EditText) findViewById(R.id.MaterialEditText_log_id);
        password= (EditText) findViewById(R.id.MaterialEditText_log_password);
        forget= (TextView) findViewById(R.id.textview_log_findpw);
        register= (TextView) findViewById(R.id.textview_log_register);
        login= (CircularProgressButton) findViewById(R.id.CircularProgressButton_log_log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setIndeterminateProgressMode(true);
                login.setProgress(100);
                AVUser.loginByMobilePhoneNumberInBackground(account.getText().toString(), password.getText().toString(), new LogInCallback<AVUser>() {
                    @Override
                    public void done(AVUser avUser, AVException e) {
                        if (e==null) {

                            Intent intent = new Intent(LogAcitivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LogAcitivity.this,"登录失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogAcitivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogAcitivity.this,FindpsdActivity.class);
                startActivity(intent);
            }
        });
    }
}
