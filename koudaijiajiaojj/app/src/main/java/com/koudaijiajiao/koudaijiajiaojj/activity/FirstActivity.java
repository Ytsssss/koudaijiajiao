package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.avos.avoscloud.AVOSCloud;
import com.koudaijiajiao.koudaijiajiaojj.R;

/**
 * Created by killandy on 2016/10/27.
 */
//2s图像
public class FirstActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this, "7JNreB73lgx4UEjAGTlmOKzg-gzGzoHsz", "gdUrGramfXMCUTROUIj0wPgm");//leancloud key
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent intent=new Intent(FirstActivity.this,GuideActivity.class);
        startActivity(intent);//如果没有记住密码进入引导界面
    }
}
