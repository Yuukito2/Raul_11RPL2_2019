package com.example.raul_11rpl2_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;


public class DetailFavourite extends AppCompatActivity {
    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;
    String id;

    TextView tv_judulfav;
    ImageView iv_posterfav;
    TextView tv_descriptfav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favourite);
        extras = getIntent().getExtras();
        tv_judulfav = (TextView)findViewById(R.id.tv_judulfav);
        tv_descriptfav = (TextView)findViewById(R.id.tv_descriptfav);
        iv_posterfav = (ImageView) findViewById(R.id.iv_posterfav);

        if (extras != null) {
            title = extras.getString("judul");
            id = extras.getString("id");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("path");
            tv_judulfav.setText(title);
            tv_descriptfav.setText(deskripsi);
            Glide.with(DetailFavourite.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(iv_posterfav);
            // and get whatever type user account id is
        }



    }
}