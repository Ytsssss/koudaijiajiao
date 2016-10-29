package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.koudaijiajiao.koudaijiajiaojj.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 99517 on 2016/10/29.
 */

public class CourseActivity extends Activity{
    final List list = new ArrayList();
    Button ok;
    CheckBox pchinese,pmath,penglish,polympiad,pcompostion,pgeneral,
            jchinese,jmath,jenglish,jchemistry,jphysics,jbiological,jpolitics,jgeography,jhistory,jcomprehensive,jartcomprehensive,jgeneral,
            hchinese,hmath,henglish,hchemistry,hphysics,hbiological,hpolitics,hgeography,hhistory,hcomprehensive,hartcomprehensive,hgeneral,
            advancedmath,uenglish,studyabroad,
            guitar,piano,violin,dance,sing,write;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.koudaijiajiao.koudaijiajiaojj.R.layout.activity_course);

        initView();
    }

    private void initView() {
        ok= (Button) findViewById(R.id.btn_course_ok);
        pchinese= (CheckBox) findViewById(R.id.check_course_pchinese);
        pmath= (CheckBox) findViewById(R.id.check_course_pmath);
        penglish= (CheckBox) findViewById(R.id.check_course_penglish);
        polympiad= (CheckBox) findViewById(R.id.check_course_polympiad);
        pcompostion= (CheckBox) findViewById(R.id.check_course_pcompostion);
        pgeneral= (CheckBox) findViewById(R.id.check_course_pgeneral);

        jchinese= (CheckBox) findViewById(R.id.check_course_jchinese);
        jmath= (CheckBox) findViewById(R.id.check_course_jmath);
        jenglish= (CheckBox) findViewById(R.id.check_course_jenglish);
        jchemistry= (CheckBox) findViewById(R.id.check_course_jchemistry);
        jphysics= (CheckBox) findViewById(R.id.check_course_jphysical);
        jbiological= (CheckBox) findViewById(R.id.check_course_jbiological);
        jpolitics= (CheckBox) findViewById(R.id.check_course_jpolitics);
        jgeography= (CheckBox) findViewById(R.id.check_course_jgeography);
        jhistory= (CheckBox) findViewById(R.id.check_course_jhistory);
        jcomprehensive= (CheckBox) findViewById(R.id.check_course_jcomprehensive);
        jartcomprehensive= (CheckBox) findViewById(R.id.check_course_jartcomprehensive);
        jgeneral= (CheckBox) findViewById(R.id.check_course_jgeneral);

        hchinese= (CheckBox) findViewById(R.id.check_course_hchinese);
        hmath= (CheckBox) findViewById(R.id.check_course_hmath);
        henglish= (CheckBox) findViewById(R.id.check_course_henglish);
        hchemistry= (CheckBox) findViewById(R.id.check_course_hchemistry);
        hphysics= (CheckBox) findViewById(R.id.check_course_hphysical);
        hbiological= (CheckBox) findViewById(R.id.check_course_hbiological);
        hpolitics= (CheckBox) findViewById(R.id.check_course_hpolitics);
        hgeography= (CheckBox) findViewById(R.id.check_course_hgeography);
        hhistory= (CheckBox) findViewById(R.id.check_course_hhistory);
        hcomprehensive= (CheckBox) findViewById(R.id.check_course_hcomprehensive);
        hartcomprehensive= (CheckBox) findViewById(R.id.check_course_hartcomprehensive);
        hgeneral= (CheckBox) findViewById(R.id.check_course_hgeneral);

        advancedmath= (CheckBox) findViewById(R.id.check_course_advancedmath);
        uenglish= (CheckBox) findViewById(R.id.check_course_uenglish);
        studyabroad= (CheckBox) findViewById(R.id.check_course_studyabroad);

        guitar= (CheckBox) findViewById(R.id.check_course_guitar);
        piano= (CheckBox) findViewById(R.id.check_course_piano);
        violin= (CheckBox) findViewById(R.id.check_course_violin);
        dance= (CheckBox) findViewById(R.id.check_course_dance);
        sing= (CheckBox) findViewById(R.id.check_course_sing);
        write= (CheckBox) findViewById(R.id.check_course_write);

        ok.setOnClickListener(ok_listener);
    }
    private Button.OnClickListener ok_listener=new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (pchinese.isChecked()) list.add("小学语文");
            if (pmath.isChecked()) list.add("小学数学");
            if (penglish.isChecked()) list.add("小学英语");
            if (polympiad.isChecked()) list.add("小学奥数");
            if (pcompostion.isChecked()) list.add("小学作文");
            if (pgeneral.isChecked()) list.add("小学全科");
            if (jchinese.isChecked()) list.add("初中语文");
            if (jmath.isChecked()) list.add("初中数学");
            if (jenglish.isChecked()) list.add("初中英语");
            if (jbiological.isChecked()) list.add("初中生物");
            if (jphysics.isChecked()) list.add("初中物理");
            if (jchemistry.isChecked()) list.add("初中化学");
            if (jhistory.isChecked()) list.add("初中历史");
            if (jpolitics.isChecked()) list.add("初中政治");
            if (jgeography.isChecked()) list.add("初中地理");
            if (jcomprehensive.isChecked()) list.add("初中理综");
            if (jartcomprehensive.isChecked()) list.add("初中文综");
            if (jgeneral.isChecked()) list.add("初中全科");
            if (hchinese.isChecked()) list.add("高中语文");
            if (hmath.isChecked()) list.add("高中数学");
            if (henglish.isChecked()) list.add("高中英语");
            if (hbiological.isChecked()) list.add("高中生物");
            if (hphysics.isChecked()) list.add("高中物理");
            if (hchemistry.isChecked()) list.add("高中化学");
            if (hhistory.isChecked()) list.add("高中历史");
            if (hpolitics.isChecked()) list.add("高中政治");
            if (hgeography.isChecked()) list.add("高中地理");
            if (hcomprehensive.isChecked()) list.add("高中理综");
            if (hartcomprehensive.isChecked()) list.add("高中文综");
            if (hgeneral.isChecked()) list.add("高中全科");
            if (advancedmath.isChecked()) list.add("高等数学");
            if (uenglish.isChecked()) list.add("大学英语");
            if (studyabroad.isChecked()) list.add("出国留学");
            if (guitar.isChecked()) list.add("吉他");
            if (violin.isChecked()) list.add("小提琴");
            if (piano.isChecked()) list.add("钢琴");
            if (sing.isChecked()) list.add("歌唱");
            if (write.isChecked()) list.add("书法");
            if (dance.isChecked()) list.add("舞蹈");

            final int RESULT_CODE = 101;
            Intent intent = new Intent();
            intent.putExtra("second", list.toString());
            setResult(RESULT_CODE, intent);
            finish();
        }
    };

}
