package com.example.androidpracticeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class NewOperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);
        EditText operationName = (EditText) findViewById(R.id.operation_name);

    }
}
