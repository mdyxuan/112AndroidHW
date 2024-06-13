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

    private Spinner spinnerMainCourse, spinnerSideDish, spinnerDrinks;
    private TextView tvOrderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        spinnerMainCourse = findViewById(R.id.spinner_main_course);
        spinnerSideDish = findViewById(R.id.spinner_side_dish);
        spinnerDrinks = findViewById(R.id.spinner_drinks);
        tvOrderSummary = findViewById(R.id.tv_order_summary);

        // 设置 Spinner 适配器
        ArrayAdapter<CharSequence> mainCourseAdapter = ArrayAdapter.createFromResource(this,
                R.array.main_course_array, android.R.layout.simple_spinner_item);
        mainCourseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMainCourse.setAdapter(mainCourseAdapter);

        ArrayAdapter<CharSequence> sideDishAdapter = ArrayAdapter.createFromResource(this,
                R.array.side_dish_array, android.R.layout.simple_spinner_item);
        sideDishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSideDish.setAdapter(sideDishAdapter);

        ArrayAdapter<CharSequence> drinksAdapter = ArrayAdapter.createFromResource(this,
                R.array.drinks_array, android.R.layout.simple_spinner_item);
        drinksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDrinks.setAdapter(drinksAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 处理菜单项选择
        if (item.getItemId() == R.id.toSend)
        {
            String mainCourse = spinnerMainCourse.getSelectedItem().toString();
            String sideDish = spinnerSideDish.getSelectedItem().toString();
            String drink = spinnerDrinks.getSelectedItem().toString();

            String orderSummary = "主餐: " + mainCourse + "\n附餐: " + sideDish + "\n饮料: " + drink;
            tvOrderSummary.setText(orderSummary);
            return true;
        }
        else if(item.getItemId() == R.id.toCancel)
        {
            spinnerMainCourse.setSelection(0);
            spinnerSideDish.setSelection(0);
            spinnerDrinks.setSelection(0);
            tvOrderSummary.setText("");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}