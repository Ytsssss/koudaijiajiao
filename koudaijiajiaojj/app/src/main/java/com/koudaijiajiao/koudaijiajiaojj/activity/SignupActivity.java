package com.koudaijiajiao.koudaijiajiaojj.activity;

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
import com.koudaijiajiao.koudaijiajiaojj.R;

/**
 * Created by killandy on 2016/10/27.
 */
//注册界面
public class SignupActivity extends Activity{
    EditText phonenumber,username,password,agnpassword,identifycode;
    Button getidentifycode, signup;
    private String phone_str,password_str,agpassword_str,identifycode_str,username_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();

        getidentifycode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AVOSCloud.requestSMSCodeInBackground(phonenumber.getText().toString(),new RequestMobileCodeCallback() {
                    @Override
                    public void done(AVException e) {
                        // 发送失败可以查看 e 里面提供的信息
                        if (e == null) {
                            Toast.makeText(SignupActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(SignupActivity.this,"发送失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phonenumber.getText())) {
                    Toast.makeText(SignupActivity.this,"手机号码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    phone_str=phonenumber.getText().toString();
                }
                if (TextUtils.isEmpty(password.getText())) {
                    Toast.makeText(SignupActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    password_str=password.getText().toString();
                }
                if (TextUtils.isEmpty(agnpassword.getText())) {
                    Toast.makeText(SignupActivity.this,"请确认密码",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    agpassword_str=agnpassword.getText().toString();
                }
                if (TextUtils.isEmpty(identifycode.getText())) {
                    Toast.makeText(SignupActivity.this,"验证码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    identifycode_str=identifycode.getText().toString();
                }
                if (TextUtils.isEmpty(username.getText())) {
                    Toast.makeText(SignupActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    username_str=username.getText().toString();
                }

                AVOSCloud.verifyCodeInBackground(identifycode_str, phone_str, new AVMobilePhoneVerifyCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            AVUser user = new AVUser();// 新建 AVUser 对象实例
                            user.setUsername(username_str);// 设置用户名
                            user.setPassword(password_str);// 设置密码
                            user.setMobilePhoneNumber(phone_str);
                            user.signUpInBackground(new SignUpCallback() {
                                public void done(AVException e) {
                                    if (e == null) {
                                        Toast.makeText(SignupActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                        // successfully
                                    } else {
                                        Toast.makeText(SignupActivity.this,"注册失败 "+e.getMessage(),Toast.LENGTH_LONG).show();
                                        // failed
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(SignupActivity.this,"验证码错误！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void initView() {
        phonenumber= (EditText) findViewById(R.id.edit_signup_phonenumber);
        username= (EditText) findViewById(R.id.edit_signup_username);
        password= (EditText) findViewById(R.id.edit_signup_password);
        agnpassword= (EditText) findViewById(R.id.edit_signup_agnpassword);
        identifycode= (EditText) findViewById(R.id.edit_signup_identifycode);
        getidentifycode= (Button) findViewById(R.id.btn_signup_getidentifycode);
        signup= (Button) findViewById(R.id.btn_signup_signup);
    }
}
