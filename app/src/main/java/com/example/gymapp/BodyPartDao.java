package com.example.gymapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BodyPartDao {
    @Insert
    void Insert(BodyPart bodyPart);

    @Delete
    void Delete(BodyPart bodyPart);

    @Delete
    void Update(BodyPart bodyPart);

    @Query("SELECT * FROM bodyPart_table")
    LiveData<List<BodyPart>> getAllBodyParts();

}
