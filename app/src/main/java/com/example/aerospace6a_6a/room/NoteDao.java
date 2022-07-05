package com.example.aerospace6a_6a.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.aerospace6a_6a.room.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT*FROM note")
    List<Note> getAll();

    @Insert
    void insert(Note note);

//    @Query("SELECT*FROM note")
//    LiveData<List<Note>> getAllLive();

    @Delete
    void delete(Note note);


//    @Update
//    void update(Note note);
//
//    @Query("SELECT * FROM note ORDER BY name ASC")
//    List<Note> sortAll();
}
