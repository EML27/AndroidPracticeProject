package com.example.androidpracticeproject.dataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface OperationDao {

    @Query("SELECT * FROM Operation")
    List<Operation> getAll();

    @Query("SELECT * FROM Operation WHERE id = :id")
    Operation getById(long id);

    @Query("SELECT * FROM Operation WHERE type = :type")
    Operation getByType(Type type);

    @Insert
    void insert(Operation operation);


}
