package com.example.aerospace6a_6a;

import android.app.Application;

import androidx.room.Room;

import com.example.aerospace6a_6a.room.AppDataBase;

public class App extends Application {
    private static AppDataBase database;
    @Override
    public void onCreate() {
        super.onCreate();
        database= Room
                .databaseBuilder(this,AppDataBase.class,"database")
                .allowMainThreadQueries()
                .build();
    }
    public static AppDataBase getDataBase() {

        return database;
    }
}
