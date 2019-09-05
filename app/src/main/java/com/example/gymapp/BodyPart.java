package com.example.gymapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bodyPart_table")
public class BodyPart {
   @PrimaryKey(autoGenerate = true)
   private Integer id;

   private String bodyPartName;

   //Constructor
   public BodyPart(String bodyPartName){
       this.bodyPartName = bodyPartName;
   }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBodyPartName() {
        return bodyPartName;
    }

}
