package com.example.aerospace6a_6a.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "note")

public class Note {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name ="t_name")
    private String t_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }


    // запоминает текст

}

