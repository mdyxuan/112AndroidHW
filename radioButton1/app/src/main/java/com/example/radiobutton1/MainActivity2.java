package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView textView = findViewById(R.id.textView3);


        String outputStr = getIntent().getStringExtra("output");
        String name = getIntent().getStringExtra("ticket");


        textView.setText("訂單明細:"+ "\n" +outputStr + "\n" + "購買張數:"+ name +"張");
    }
}