package com.example.pas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

public class DetailTeamFavorite extends AppCompatActivity {

    Bundle extras;
    String title;
    String date;
    String deskripsi;
    String path;
    String id;

    TextView tvjudul;
    ImageView ivposter;
    TextView tvdesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favorite);
        extras = getIntent().getExtras();
        tvjudul = (TextView)findViewById(R.id.tvjudul_favourite);
        tvdesc = (TextView)findViewById(R.id.txtdeskripsi_favourite);
        ivposter = (ImageView) findViewById(R.id.ivposter_favourite);

        if (extras != null) {
            title = extras.getString("judul");
            id = extras.getString("id");
            date = extras.getString("date");
            deskripsi = extras.getString("deskripsi");
            path = extras.getString("path");

            tvjudul.setText(title);
            tvdesc.setText(deskripsi);
            Glide.with(DetailTeamFavorite.this)
                    .load(path)
                    .override(Target.SIZE_ORIGINAL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ivposter);
            // and get whatever type user account id is
        }
    }}