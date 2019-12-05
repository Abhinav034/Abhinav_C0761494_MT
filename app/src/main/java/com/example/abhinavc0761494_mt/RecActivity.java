package com.example.abhinavc0761494_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecActivity extends AppCompatActivity {

    TextView textView;
    TextView textViewrent;
    TextView textViewdays;
    TextView textViewage;
    TextView textViewamount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        textView = findViewById(R.id.carText);
      //  textViewrent = findViewById(R.id.rentText);
        textViewdays = findViewById(R.id.daysText);
        textViewage = findViewById(R.id.ageText);
        textViewamount = findViewById(R.id.totalAmountText);

        Intent intent =  getIntent();
        String car = (String) intent.getExtras().get("car");
     //   String rent = (String) intent.getExtras().get("rent");
        String days = (String) intent.getExtras().get("days");
        String age = (String) intent.getExtras().get("age");
        String totalAmount  = (String) intent.getExtras().get("totalAmount");
        textView.setText(car);
       // textViewrent.setText(rent);
        textViewdays.setText(days);
        textViewage.setText(age);
        textViewamount.setText(totalAmount);



    }
}
