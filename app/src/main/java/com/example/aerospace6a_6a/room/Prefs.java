package com.example.aerospace6a_6a.room;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {
    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences
                ("settings", Context.MODE_PRIVATE);
    }

    public void saveString(String textProfile) {
        preferences.edit().putString("text", textProfile).apply();
    }
    public String getStringData() {
        return preferences.getString("text", "");
    }


    public void saveImage(String result) {
        preferences.edit().putString("avatar", result).apply();
    }

    public String getAvatar(){ return preferences.getString("avatar", null);
    }

}
