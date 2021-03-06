package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.koudaijiajiao.koudaijiajiaojj.R;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.koudaijiajiao.koudaijiajiaojj.R;
import com.koudaijiajiao.koudaijiajiaojj.unity.Location;


/**
 * Created by killandy on 2016/10/27.
 */

//课程信息添加
public class AddcourseActivity  extends Activity {

    TextView course;
    Button addcourse;
    final int RESULT_CODE=101;
    final int REQUEST_CODE=1;

    //------------------ 定位相关-------------
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = null;
    //location实体
    public Location location = null;
    //------------------ 定位相关-------------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);
        initView();
        //定位设置
        initLocation();

        initClick();

    }

    private void initClick() {

        addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddcourseActivity.this,CourseActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });//添加学科按钮


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE) {
            if(resultCode==RESULT_CODE) {
                String result=data.getStringExtra("second");
                course.setText(result);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void initView() {
        addcourse= (Button) findViewById(R.id.btn_course_addcourse);//添加学科按钮
        course= (TextView) findViewById(R.id.text_addcourse_course);//显示科目
    }


//定位
    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        location.setLatitude(amapLocation.getLatitude());//获取纬度
                        location.setLongitude(amapLocation.getLongitude());//获取经度
                        location.setAddress(amapLocation.getAddress());//地址
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "Location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                    }
                }
            }
        };
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }
}
