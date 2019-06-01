package com.example.json;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowImageActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView tvName;
    private AllJsonData allJsonData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        Intent intent = getIntent();
        allJsonData = (AllJsonData) intent.getSerializableExtra("AllJsonData");

        viewPager = findViewById(R.id.vp_image);
        tvName = findViewById(R.id.tv_name);
        ImageAdapter imageAdapter = new ImageAdapter(this,allJsonData);
        viewPager.setAdapter(imageAdapter);

        if (allJsonData.getName() != null)
        {
            tvName.setText(allJsonData.getName());
        }
    }


}
