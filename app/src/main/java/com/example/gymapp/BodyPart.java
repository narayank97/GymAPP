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

    //GETTER
    public Integer getId() {
        return id;
    }

    //SETTER
    public void setId(Integer id) {
        this.id = id;
    }

    //GETTER
    public String getBodyPartName() {
        return bodyPartName;
    }

}
