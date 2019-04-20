package com.example.androidpracticeproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addOperationButton = findViewById(R.id.add_operation_button);
        Button targetButton = findViewById(R.id.target_button);
        Button historyButton = findViewById(R.id.history_button);

        Intent addOperationIntent = new Intent(MainActivity.this,NewOperationActivity.class);
        addOperationButton.setOnClickListener(v -> startActivity(addOperationIntent));


        Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
        historyButton.setOnClickListener(v -> startActivity(historyIntent));
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView balance = findViewById(R.id.balance);

        TextView leftToday = findViewById(R.id.left_today);
        SharedPreferences appSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        balance.setText(String.valueOf(appSettings.getFloat("balance", 0)));


        Calendar date = Calendar.getInstance();
        float moneyLeft = appSettings.getFloat("balance", 0) / (31 - date.DATE);
        // =================== осторожно, стремные костыли
        /*
        moneyleft *= 100;
        int intMoneyLeft = (int) moneyleft;
        moneyleft = Float.parseFloat(String.valueOf(intMoneyLeft)) / 100;*/
        //==================== глаза не вырывать
        leftToday.setText(String.format("%.2f",moneyLeft));


    }
}
