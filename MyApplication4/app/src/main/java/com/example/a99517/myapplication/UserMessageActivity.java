package com.example.a99517.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//import android.app.Activity;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by 99517 on 2016/7/19.
// */
//public class UserMessageActivity extends Activity{
//    private List<String> list=new ArrayList<String>();
//    private TextView chooseDay;
//    private Spinner mySpinner;//选择星期几
//    private ArrayAdapter<String> adapter;
//    private EditText subject,grade,price;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_usermessage);
//        Init();//初始化
//        GetMessage();
//    }
//    private void Init() {
//        chooseDay= (TextView) findViewById(R.id.textview_usermessage_day);
//        mySpinner= (Spinner) findViewById(R.id.spinner_usermessage_time);
//        subject= (EditText) findViewById(R.id.edittext_usermessage_subject);
//        grade= (EditText) findViewById(R.id.editview_usermessage_grade);
//        price= (EditText) findViewById(R.id.editview_usermessage_price);
//    }
//    private void GetMessage() {
//        list.add("星期一");
//        list.add("星期二");
//        list.add("星期三");
//        list.add("星期四");
//        list.add("星期五");
//        list.add("星期六");
//        list.add("星期天");
//
//        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mySpinner.setAdapter(adapter);
//        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                chooseDay.setText("您选择的是："+adapter.getItem(position));
//                parent.setVisibility(View.VISIBLE);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                chooseDay.setText("NONE");
//                parent.setVisibility(View.VISIBLE);
//            }
//        });
//        /*下拉菜单弹出的内容选项触屏事件处理*/
//        mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return false;
//            }
//        });
//        /*下拉菜单弹出的内容选项焦点改变事件处理*/
//        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//            }
//        });
//    }
//
//
//}



    public class UserMessageActivity extends Activity implements View.OnClickListener{

        private ImageView img_class11,img_class12,img_class13,img_class14,img_class15,img_class16, img_class17,
                img_class21,img_class22,img_class23,img_class24,img_class25,img_class26,img_class27,
                img_class31,img_class32,img_class33,img_class34,img_class35,img_class36,img_class37;
         protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_usermessage);

             initView();
         }

        private void initView() {
            img_class11= (ImageView) findViewById(R.id.imageview_usermessage_11);
            img_class11.setOnClickListener(this);

            img_class12= (ImageView) findViewById(R.id.imageview_usermessage_12);
            img_class12.setOnClickListener(this);

            img_class13= (ImageView) findViewById(R.id.imageview_usermessage_13);
            img_class13.setOnClickListener(this);

            img_class14= (ImageView) findViewById(R.id.imageview_usermessage_14);
            img_class14.setOnClickListener(this);

            img_class15= (ImageView) findViewById(R.id.imageview_usermessage_15);
            img_class15.setOnClickListener(this);

            img_class16= (ImageView) findViewById(R.id.imageview_usermessage_16);
            img_class16.setOnClickListener(this);

            img_class17= (ImageView) findViewById(R.id.imageview_usermessage_17);
            img_class17.setOnClickListener(this);

            img_class21= (ImageView) findViewById(R.id.imageview_usermessage_21);
            img_class21.setOnClickListener(this);

            img_class22= (ImageView) findViewById(R.id.imageview_usermessage_22);
            img_class22.setOnClickListener(this);

            img_class23= (ImageView) findViewById(R.id.imageview_usermessage_23);
            img_class23.setOnClickListener(this);

            img_class24= (ImageView) findViewById(R.id.imageview_usermessage_24);
            img_class24.setOnClickListener(this);

            img_class25= (ImageView) findViewById(R.id.imageview_usermessage_25);
            img_class25.setOnClickListener(this);

            img_class26= (ImageView) findViewById(R.id.imageview_usermessage_26);
            img_class26.setOnClickListener(this);

            img_class27= (ImageView) findViewById(R.id.imageview_usermessage_27);
            img_class27.setOnClickListener(this);

            img_class31= (ImageView) findViewById(R.id.imageview_usermessage_31);
            img_class31.setOnClickListener(this);

            img_class32= (ImageView) findViewById(R.id.imageview_usermessage_32);
            img_class32.setOnClickListener(this);

            img_class33= (ImageView) findViewById(R.id.imageview_usermessage_33);
            img_class33.setOnClickListener(this);

            img_class34= (ImageView) findViewById(R.id.imageview_usermessage_34);
            img_class34.setOnClickListener(this);

            img_class35= (ImageView) findViewById(R.id.imageview_usermessage_35);
            img_class35.setOnClickListener(this);

            img_class36= (ImageView) findViewById(R.id.imageview_usermessage_36);
            img_class36.setOnClickListener(this);

            img_class37= (ImageView) findViewById(R.id.imageview_usermessage_37);
            img_class37.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageview_usermessage_11:
                    if(img_class11.getTag().equals("no")) {
                        img_class11.setImageResource(R.drawable.pic1);
                        img_class11.setTag("yes");
                    }
                    else {
                        img_class11.setImageResource(R.drawable.pic0);
                        img_class11.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_12:
                    if(img_class12.getTag().equals("no")) {
                        img_class12.setImageResource(R.drawable.pic1);
                        img_class12.setTag("yes");
                    }
                    else {
                        img_class12.setImageResource(R.drawable.pic0);
                        img_class12.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_13:
                    if(img_class13.getTag().equals("no")) {
                        img_class13.setImageResource(R.drawable.pic1);
                        img_class13.setTag("yes");
                    }
                    else {
                        img_class13.setImageResource(R.drawable.pic0);
                        img_class13.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_14:
                    if(img_class14.getTag().equals("no")) {
                        img_class14.setImageResource(R.drawable.pic1);
                        img_class14.setTag("yes");
                    }
                    else {
                        img_class14.setImageResource(R.drawable.pic0);
                        img_class14.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_15:
                    if(img_class15.getTag().equals("no")) {
                        img_class15.setImageResource(R.drawable.pic1);
                        img_class15.setTag("yes");
                    }
                    else {
                        img_class15.setImageResource(R.drawable.pic0);
                        img_class15.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_16:
                    if(img_class16.getTag().equals("no")) {
                        img_class16.setImageResource(R.drawable.pic1);
                        img_class16.setTag("yes");
                    }
                    else {
                        img_class16.setImageResource(R.drawable.pic0);
                        img_class16.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_17:
                    if(img_class17.getTag().equals("no")) {
                        img_class17.setImageResource(R.drawable.pic1);
                        img_class17.setTag("yes");
                    }
                    else {
                        img_class17.setImageResource(R.drawable.pic0);
                        img_class17.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_21:
                    if(img_class21.getTag().equals("no")) {
                        img_class21.setImageResource(R.drawable.pic1);
                        img_class21.setTag("yes");
                    }
                    else {
                        img_class21.setImageResource(R.drawable.pic0);
                        img_class21.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_22:
                    if(img_class22.getTag().equals("no")) {
                        img_class22.setImageResource(R.drawable.pic1);
                        img_class22.setTag("yes");
                    }
                    else {
                        img_class22.setImageResource(R.drawable.pic0);
                        img_class22.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_23:
                    if(img_class23.getTag().equals("no")) {
                        img_class23.setImageResource(R.drawable.pic1);
                        img_class23.setTag("yes");
                    }
                    else {
                        img_class23.setImageResource(R.drawable.pic0);
                        img_class23.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_24:
                    if(img_class24.getTag().equals("no")) {
                        img_class24.setImageResource(R.drawable.pic1);
                        img_class24.setTag("yes");
                    }
                    else {
                        img_class24.setImageResource(R.drawable.pic0);
                        img_class24.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_25:
                    if(img_class25.getTag().equals("no")) {
                        img_class25.setImageResource(R.drawable.pic1);
                        img_class25.setTag("yes");
                    }
                    else {
                        img_class25.setImageResource(R.drawable.pic0);
                        img_class25.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_26:
                    if(img_class26.getTag().equals("no")) {
                        img_class26.setImageResource(R.drawable.pic1);
                        img_class26.setTag("yes");
                    }
                    else {
                        img_class26.setImageResource(R.drawable.pic0);
                        img_class26.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_27:
                    if(img_class27.getTag().equals("no")) {
                        img_class27.setImageResource(R.drawable.pic1);
                        img_class27.setTag("yes");
                    }
                    else {
                        img_class27.setImageResource(R.drawable.pic0);
                        img_class27.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_31:
                    if(img_class31.getTag().equals("no")) {
                        img_class31.setImageResource(R.drawable.pic1);
                        img_class31.setTag("yes");
                    }
                    else {
                        img_class31.setImageResource(R.drawable.pic0);
                        img_class31.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_32:
                    if(img_class32.getTag().equals("no")) {
                        img_class32.setImageResource(R.drawable.pic1);
                        img_class32.setTag("yes");
                    }
                    else {
                        img_class32.setImageResource(R.drawable.pic0);
                        img_class32.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_33:
                    if(img_class33.getTag().equals("no")) {
                        img_class33.setImageResource(R.drawable.pic1);
                        img_class33.setTag("yes");
                    }
                    else {
                        img_class33.setImageResource(R.drawable.pic0);
                        img_class33.setTag("no");
                    }
                    break;


                case R.id.imageview_usermessage_34:
                    if(img_class34.getTag().equals("no")) {
                        img_class34.setImageResource(R.drawable.pic1);
                        img_class34.setTag("yes");
                    }
                    else {
                        img_class34.setImageResource(R.drawable.pic0);
                        img_class34.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_35:
                    if(img_class35.getTag().equals("no")) {
                        img_class35.setImageResource(R.drawable.pic1);
                        img_class35.setTag("yes");
                    }
                    else {
                        img_class35.setImageResource(R.drawable.pic0);
                        img_class35.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_36:
                    if(img_class36.getTag().equals("no")) {
                        img_class36.setImageResource(R.drawable.pic1);
                        img_class36.setTag("yes");
                    }
                    else {
                        img_class36.setImageResource(R.drawable.pic0);
                        img_class36.setTag("no");
                    }
                    break;

                case R.id.imageview_usermessage_37:
                    if(img_class37.getTag().equals("no")) {
                        img_class37.setImageResource(R.drawable.pic1);
                        img_class37.setTag("yes");
                    }
                    else {
                        img_class37.setImageResource(R.drawable.pic0);
                        img_class37.setTag("no");
                    }
                    break;
            }
        }
    }