package com.example.androidpracticeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.androidpracticeproject.dataBase.AppDatabase;
import com.example.androidpracticeproject.dataBase.Operation;
import com.example.androidpracticeproject.dataBase.OperationDao;


import java.util.Calendar;

public class NewOperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);
        EditText operationName = (EditText) findViewById(R.id.et_name);
        EditText costOfOperation = (EditText) findViewById(R.id.et_cost);
        Spinner typeSpinner = (Spinner)findViewById(R.id.spinner);

        ImageButton addButton = findViewById(R.id.btn_add);
        addButton.setOnClickListener(v -> {
            String nameOfOperation = operationName.getText().toString();
            float operationCost = Float.parseFloat(costOfOperation.getText().toString());
            AppDatabase db = App.getInstance().getDatabase();
            Operation operation = new Operation();
            operation.name = nameOfOperation;
            operation.cost = operationCost;
            Calendar calendar = Calendar.getInstance();
            operation.date = calendar.getTimeInMillis();
            OperationDao operationDao = db.operationDao();
            operationDao.insert(operation);
        });
    }
}
