package com.example.raul_11rpl2_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.RequestOptions;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailMovie extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    ModelMovieRealm movieModel;


    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;
    int id;

    TextView tv_judul;
    ImageView iv_poster;
    TextView tv_descript;
    Button btn_bookmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        extras = getIntent().getExtras();
        tv_judul = (TextView)findViewById(R.id.tv_judul);
        tv_descript = (TextView)findViewById(R.id.tv_descript);
        iv_poster = (ImageView) findViewById(R.id.iv_poster);
        btn_bookmark = (Button) findViewById(R.id.btn_bookmark);

        if (extras != null) {
            title = extras.getString("judul");
            id = extras.getInt("id");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("path");
            tv_judul.setText(title);
            tv_descript.setText(deskripsi);
            Glide.with(DetailMovie.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(iv_poster);
            // and get whatever type user account id is
        }

        //Set up Realm
        Realm.init(DetailMovie.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);


        btn_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieModel = new ModelMovieRealm();
                movieModel.setDesc(deskripsi);
                movieModel.setJudul(title);
                movieModel.setPath(path);
                movieModel.setReleaseDate(date);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(movieModel);

            }
        });
    }
}