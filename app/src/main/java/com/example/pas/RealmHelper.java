package com.example.pas;

import android.util.Log;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;
    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final ModelTeamRealm movieModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(ModelTeamRealm.class).max("id");
                    int nextId;
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    movieModel.setId(nextId);
                    ModelTeamRealm model = realm.copyToRealm(movieModel);
                } else {
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }
    // untuk memanggil semua data
    public List<ModelTeamRealm> getAllTeams(){
        RealmResults<ModelTeamRealm> results = realm.where(ModelTeamRealm.class).findAll();
        return results;
    }

    public void delete(Integer id){
        final RealmResults<ModelTeamRealm> model = realm.where(ModelTeamRealm.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}