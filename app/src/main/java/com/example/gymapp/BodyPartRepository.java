package com.example.gymapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BodyPartRepository {

    private BodyPartDao bodyPartDao;
    private LiveData<List<BodyPart>> allBodyParts;

    public BodyPartRepository(Application application){
        BodyPartDatabase database = BodyPartDatabase.getInstance(application);
        bodyPartDao = database.bodyPartDao();
        allBodyParts = bodyPartDao.getAllBodyParts();
    }

    public void Insert(BodyPart bodyPart){
         new InsertBodyPartAsyncTask(bodyPartDao).execute(bodyPart);
    }
    public void Delete(BodyPart bodyPart){
        new DeleteBodyPartAsyncTask(bodyPartDao).execute(bodyPart);
    }

    public LiveData<List<BodyPart>> getAllBodyParts(){
        return allBodyParts;
    }

    private static class InsertBodyPartAsyncTask extends AsyncTask<BodyPart,Void,Void>{
        private BodyPartDao bodyPartDao;

        private InsertBodyPartAsyncTask(BodyPartDao bodyPartDao){
            this.bodyPartDao = bodyPartDao;
        }

        @Override
        protected Void doInBackground(BodyPart ... bodyParts){
            bodyPartDao.Insert(bodyParts[0]);
            return null;
        }
    }

    private static class DeleteBodyPartAsyncTask extends AsyncTask<BodyPart,Void,Void>{
        private BodyPartDao bodyPartDao;

        private DeleteBodyPartAsyncTask(BodyPartDao bodyPartDao){
            this.bodyPartDao = bodyPartDao;
        }

        @Override
        protected Void doInBackground(BodyPart ... bodyParts){
            bodyPartDao.Delete(bodyParts[0]);
            return null;
        }
    }

}
