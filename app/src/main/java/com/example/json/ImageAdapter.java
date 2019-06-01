package com.example.json;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.List;

public class ImageAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private AllJsonData allJsonData;
    Context context;
    private ImageView iv_image;

    public ImageAdapter(Context context, AllJsonData allJsonData) {
        this.allJsonData = allJsonData;
        inflater =LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return allJsonData.getImages().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    public Object instantiateItem (ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.activity_custom_view,container,false);
        ImageView iv_image = view.findViewById(R.id.iv_image);
        TextView tx_des = view.findViewById(R.id.tv_description);
        Glide.with(context).load(allJsonData.getImages().get(position).getName()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv_image);
        tx_des.setText(allJsonData.getImages().get(position).getDescription());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((View) object);
    }
}
