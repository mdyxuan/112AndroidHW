package com.example.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void button_Click(View view)
    {
        EditText edtaccount = (EditText) findViewById(R.id.edtaccount);
        EditText edtpsd = (EditText) findViewById(R.id.edtpsd);
        TextView txvShow = (TextView) findViewById(R.id.txvShow);
        String account = edtaccount.getText().toString();
        String password = edtpsd.getText().toString();
        if(account.equals("12345678") && password.equals("123"))
        {
            txvShow.setText("登入成功");
        }
        else
        {
            txvShow.setText("帳號或密碼錯誤");
        }

    }
}