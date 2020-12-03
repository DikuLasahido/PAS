package com.example.pas;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ModelTeam  {
    int idTeams;
    String strTeam;
    String strStadium;
    String strStadiumDesc;
    String strStadiumLoc;
    String strTeamBadge;
    String intFormedYear;
    String strDesc;
    String strLeague;

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public int getIdTeams() {
        return idTeams;
    }

    public void setIdTeams(int idTeams) {
        this.idTeams = idTeams;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrStadiumDesc() {
        return strStadiumDesc;
    }

    public void setStrStadiumDesc(String strStadiumDesc) {
        this.strStadiumDesc = strStadiumDesc;
    }

    public String getStrStadiumLoc() {
        return strStadiumLoc;
    }

    public void setStrStadiumLoc(String strStadiumLoc) {
        this.strStadiumLoc = strStadiumLoc;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }
}

