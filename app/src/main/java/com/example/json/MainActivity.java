package com.example.json;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText edtText;
    private TextView tvText;
    private Button btGet;
    AllJsonData allJsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText = findViewById(R.id.edt_text);
        tvText = findViewById(R.id.tv_text);
        btGet = findViewById(R.id.bt_get);


        allJsonData = new AllJsonData();

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadJson().execute("" + edtText.getText());
                //new ReadJson().execute("http://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json");
                //new LoadImage().execute("http://45.55.141.122/data/img1.jpg");
                //new LoadImage().execute(""+ tvText.getText());
                //Toast.makeText(MainActivity.this, tvText.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ReadJson extends AsyncTask <String, Void, AllJsonData> {
        @Override
        protected AllJsonData doInBackground(String... strings) {
            allJsonData = null;
            try {
                URL url =new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(),"UTF-8");
                allJsonData = new Gson().fromJson(inputStreamReader,AllJsonData.class);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return allJsonData;
        }

        @Override
        protected void onPostExecute(AllJsonData allJsonData) {
            super.onPostExecute(allJsonData);
            if (allJsonData != null)
            {
                Intent intent = new Intent(MainActivity.this, ShowImageActivity.class);
                intent.putExtra("AllJsonData",allJsonData);
                startActivity(intent);
            }
        }
    }

}
