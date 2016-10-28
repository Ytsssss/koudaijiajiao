package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

import com.koudaijiajiao.koudaijiajiaojj.R;

public class MainActivity extends AppCompatActivity {

    public Button btn_addcourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddcourseActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btn_addcourse= (Button) findViewById(R.id.btn_main_addcourse);
    }

}
