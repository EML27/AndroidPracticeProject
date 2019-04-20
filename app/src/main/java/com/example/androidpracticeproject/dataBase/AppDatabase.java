package com.example.androidpracticeproject.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Operation.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract OperationDao operationDao();

    private static final String DATABASE_NAME = "name.db";

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {//application context only
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME)
                    // allow queries on the main thread.
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }
}
