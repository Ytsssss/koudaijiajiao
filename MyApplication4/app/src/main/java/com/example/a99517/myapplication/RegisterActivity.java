package com.example.a99517.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVMobilePhoneVerifyCallback;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.avos.avoscloud.SignUpCallback;

/**
 * Created by 99517 on 2016/6/10.
 */
public class RegisterActivity extends Activity {
    private EditText account,username,password,agpassword,verifycode;
    private Button getverifycode,ok_button;
    private String account_str,password_str,agpassword_str,verifycode_str,username_str;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        account= (EditText) findViewById(R.id.MaterialEditText_register_phone);
        username= (EditText) findViewById(R.id.MaterialEditText_register_id);
        password= (EditText) findViewById(R.id.MaterialEditText_register_password);
        agpassword= (EditText) findViewById(R.id.MaterialEditText_register_ensurepw);
        verifycode= (EditText) findViewById(R.id.MaterialEditText_register_identify);
        getverifycode= (Button) findViewById(R.id.CircularProgressButton_register_chgidentify);
        ok_button= (Button) findViewById(R.id.CircularProgressButton_register_register);

        getverifycode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVOSCloud.requestSMSCodeInBackground(account.getText().toString(),new RequestMobileCodeCallback() {
                    @Override
                    public void done(AVException e) {
                        // 发送失败可以查看 e 里面提供的信息
                        if (e == null) {
                            Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"发送失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(account.getText())) {
                    Toast.makeText(RegisterActivity.this,"手机号码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    account_str=account.getText().toString();
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    password_str=password.getText().toString();
                }
                if (TextUtils.isEmpty(agpassword.getText())) {
                    Toast.makeText(RegisterActivity.this,"请确认密码",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    agpassword_str=agpassword.getText().toString();
                }
                if (TextUtils.isEmpty(verifycode.getText())) {
                    Toast.makeText(RegisterActivity.this,"验证码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    verifycode_str=verifycode.getText().toString();
                }
                if (TextUtils.isEmpty(username.getText())) {
                    Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    username_str=username.getText().toString();
                }

                AVOSCloud.verifyCodeInBackground(verifycode_str, account_str, new AVMobilePhoneVerifyCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            AVUser user = new AVUser();// 新建 AVUser 对象实例
                            user.setUsername(username_str);// 设置用户名
                            user.setPassword(password_str);// 设置密码
                            user.setMobilePhoneNumber(account_str);
                            user.signUpInBackground(new SignUpCallback() {
                                public void done(AVException e) {
                                    if (e == null) {
                                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(RegisterActivity.this,LogAcitivity.class);
                                        startActivity(intent);
                                        // successfully
                                    } else {
                                        Toast.makeText(RegisterActivity.this,"注册失败 "+e.getMessage(),Toast.LENGTH_SHORT).show();
                                        // failed
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this,"验证码错误！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
    }
}
