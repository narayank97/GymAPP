package com.example.gymapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BodyPart.class},version = 1)
public abstract class BodyPartDatabase extends RoomDatabase {
    //Testing out commit
}
