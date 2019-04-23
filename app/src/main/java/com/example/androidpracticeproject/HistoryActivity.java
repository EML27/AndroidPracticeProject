package com.example.androidpracticeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidpracticeproject.dataBase.*;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        AppDatabase db = AppDatabase.getInstance(this);
        OperationDao operationDao = db.operationDao();
        List<Operation> list = operationDao.getAll();


        recyclerView = (RecyclerView) findViewById(R.id.rv_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
