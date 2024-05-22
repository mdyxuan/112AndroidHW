package com.example.menuhw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner menu;
    private ListView Meal,Extra,Drink;
    private String[] MealSet,ExtraSet,DrinkSet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MealSet = getResources().getStringArray(R.array.meal);
        ExtraSet = getResources().getStringArray(R.array.extra);
        DrinkSet = getResources().getStringArray(R.array.drink);
        menu = (Spinner) findViewById(R.id.menu);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0)
                {
                    ArrayAdapter<String> a = new ArrayAdapter<>(this,
                            android.R.layout.simple_spinner_dropdown_item, MealSet);
                    Meal = (ListView) findViewById(R.id.ListView);
                    Meal.setAdapter(a);
                    Meal.setOnItemClickListener(this);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {

    }
}