package com.example.gymapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {BodyPart.class},version = 1)
public abstract class BodyPartDatabase extends RoomDatabase {
    //Testing out commit

    private static BodyPartDatabase instance;
    public abstract BodyPartDao bodyPartDao();

    public static BodyPartDatabase getInstance(Context context){

        //BUILDS DATBASE
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),BodyPartDatabase.class,
                    "bodyPart_database.db").fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();

        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>{
        private BodyPartDao bodyPartDao;

        private PopulateDBAsyncTask(BodyPartDatabase db){
            bodyPartDao = db.bodyPartDao();
        }

        @Override
        protected Void doInBackground(Void ...voids){
            bodyPartDao.Insert(new BodyPart("ARMS"));
            bodyPartDao.Insert(new BodyPart("CHEST"));
            bodyPartDao.Insert(new BodyPart("SHOULDERS"));
            bodyPartDao.Insert(new BodyPart("BACK"));
            bodyPartDao.Insert(new BodyPart("LEGS"));
            bodyPartDao.Insert(new BodyPart("CARDIO"));
            return null;
        }


    }

}
