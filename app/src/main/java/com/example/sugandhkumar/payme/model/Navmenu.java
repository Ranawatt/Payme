package com.example.sugandhkumar.payme.model;

/**
 * Created by sugandh kumar on 31-12-2017.
 */

public class Navmenu {
    public String navName;
    public String navUrl;

    public Navmenu() {
    }

    public Navmenu(String navName) {
        this.navName = navName;
    }

    public Navmenu(String navName, String navUrl) {
        this.navName = navName;
        this.navUrl = navUrl;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl;
    }
}
