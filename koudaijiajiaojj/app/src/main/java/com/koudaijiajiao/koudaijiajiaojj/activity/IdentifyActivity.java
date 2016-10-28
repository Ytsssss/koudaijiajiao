package com.koudaijiajiao.koudaijiajiaojj.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.koudaijiajiao.koudaijiajiaojj.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by killandy on 2016/10/27.
 */
//认证界面
public class IdentifyActivity extends Activity{
    EditText name, school, major, grade, idnumber, studentnumber, profile;
    Button picture, refer;
    ImageView Picture;
    String Name, School, Major, Grade, Idnumber, Studentnumber, Profile,url;
    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    private Uri imageUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);
        initView();//初始化

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File outputImage = new File(Environment.getExternalStorageDirectory(), "tempImage.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageUri = Uri.fromFile(outputImage);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
                // 启动相机程序

            }
        });//设置拍照按钮的监听事件

        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVObject usermessage = new AVObject("UserMessage");
                if (TextUtils.isEmpty(name.getText())) {
                    Toast.makeText(IdentifyActivity.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Name = name.getText().toString();
                    usermessage.put("name", Name);//姓名
                }

                if (TextUtils.isEmpty(school.getText())) {
                    Toast.makeText(IdentifyActivity.this,"学校名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    School = school.getText().toString();
                    usermessage.put("school", School);//学校
                }

                if (TextUtils.isEmpty(major.getText())) {
                    Toast.makeText(IdentifyActivity.this,"专业名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Major = major.getText().toString();
                    usermessage.put("major", Major);//专业
                }

                if (TextUtils.isEmpty(grade.getText())) {
                    Toast.makeText(IdentifyActivity.this,"年级名不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Grade = grade.getText().toString();
                    usermessage.put("grade", Grade);//年级
                }

                if (TextUtils.isEmpty(idnumber.getText())) {
                    Toast.makeText(IdentifyActivity.this,"身份证号码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Idnumber = idnumber.getText().toString();
                    usermessage.put("idnumber", Idnumber);//身份证号
                }

                if (TextUtils.isEmpty(studentnumber.getText())) {
                    Toast.makeText(IdentifyActivity.this,"学号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Studentnumber = studentnumber.getText().toString();
                    usermessage.put("studentnumber", Studentnumber);//学号
                }

                if (TextUtils.isEmpty(profile.getText())) {
                    Toast.makeText(IdentifyActivity.this,"简介不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Profile = profile.getText().toString();
                    usermessage.put("profile", Profile);//简介
                }

                AVFile file = null;
                try {
                    file = AVFile.withAbsoluteLocalPath("tempImage.jpg", Environment.getExternalStorageDirectory() + "/tempImage.jpg");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                file.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        // 成功或失败处理...
                    }
                });

                if (Picture.getDrawable()==null){
                    Toast.makeText(IdentifyActivity.this,"学生证照片不存在",Toast.LENGTH_SHORT).show();
                    return;
                }else { url=file.getUrl();
                    usermessage.put("Url",url);
                }
                usermessage.saveInBackground();//存储信息
                Intent intent = new Intent(IdentifyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        name = (EditText) findViewById(R.id.edit_identify_name);
        school = (EditText) findViewById(R.id.edit_identify_school);
        major = (EditText) findViewById(R.id.edit_identify_profession);
        grade = (EditText) findViewById(R.id.edit_identify_grade);
        idnumber = (EditText) findViewById(R.id.edit_identify_idcard);
        studentnumber = (EditText) findViewById(R.id.edit_identify_studentid);
        profile = (EditText) findViewById(R.id.edit_identify_profile);
        picture = (Button) findViewById(R.id.edit_identify_getphoto);
        refer = (Button) findViewById(R.id.edit_identify_send);
        Picture = (ImageView) findViewById(R.id.edit_identify_photo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                }
                break;
            case CROP_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream
                                (getContentResolver().openInputStream(imageUri));
                        Picture.setImageBitmap(bitmap); // 将裁剪后的照片显示出来

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;

        }
    }
}
