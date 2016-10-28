package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVOSCloud;
import com.koudaijiajiao.koudaijiajiaojj.R;

/**
 * Created by killandy on 2016/10/27.
 */
//引导界面
public class GuideActivity extends Activity{
    Button signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GuideActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        signup= (Button) findViewById(R.id.btn_guide_signup);
        login= (Button) findViewById(R.id.btn_guide_login);
    }
}
