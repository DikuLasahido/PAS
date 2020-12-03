package com.example.pas;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ListTeamFavorite extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    private RecyclerView recyclerView;
    private FavoriteAdapterTeam adapter;
    private List<ModelTeamRealm> modelTeam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_team);
        recyclerView = findViewById(R.id.rvdata);


        // Setup Realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        modelTeam = new ArrayList<>();

        modelTeam = realmHelper.getAllTeams();

        adapter = new FavoriteAdapterTeam(modelTeam, new FavoriteAdapterTeam.Callback() {
            @Override
            public void onClick(int position) {
                Intent move = new Intent(getApplicationContext(), DetailTeamFavorite.class);
                move.putExtra("judul",modelTeam.get(position).getJudul());
                move.putExtra("path",modelTeam.get(position).getPath());
                move.putExtra("date",modelTeam.get(position).getReleaseDate());
                move.putExtra("deskripsi",modelTeam.get(position).getDesc());

                startActivity(move);
            }

            @Override
            public void test() {

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}