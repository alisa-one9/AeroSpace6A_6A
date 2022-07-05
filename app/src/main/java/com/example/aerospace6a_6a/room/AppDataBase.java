package com.example.aerospace6a_6a.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.aerospace6a_6a.room.NoteDao;
import com.example.aerospace6a_6a.room.Note;


@Database(entities = {Note.class},version = 2)

public abstract class AppDataBase extends RoomDatabase {

    public  abstract  NoteDao noteDao();

}
