package com.example.androidpracticeproject.dataBase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Operation {
    @PrimaryKey
    public int id;
    @NonNull
    public String name;

    public boolean isAddition;

    //public Type type;
    public long date;

    public float cost;
}
