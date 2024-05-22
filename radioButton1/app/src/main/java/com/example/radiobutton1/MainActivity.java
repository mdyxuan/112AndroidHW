//A110222018
package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        EditText EdtTicket = (EditText) findViewById(R.id.EdtTicket);
        Button CheckBtn = (Button) findViewById(R.id.CheckBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";
                String name ="";
                name = EdtTicket.getText().toString();
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rdbBoy.isChecked())
                    outputStr += getResources().getString(R.string.male)+ "\n";
                else if (rdbGirl.isChecked())
                    outputStr += getResources().getString(R.string.female)+ "\n";

                RadioGroup rgType =(RadioGroup) findViewById(R.id.rgType);
                if(rgType.getCheckedRadioButtonId() == R.id.rdbAdult)
                    outputStr += getResources().getString(R.string.regularticket)+ "\n";
                else if(rgType.getCheckedRadioButtonId() == R.id.rdbChild)
                    outputStr += getResources().getString(R.string.childticket)+ "\n";
                else if(rgType.getCheckedRadioButtonId() == R.id.rdbStudent)
                    outputStr += getResources().getString(R.string.studentticket)+ "\n";
                TextView output = (TextView) findViewById(R.id.lblOutput);

                output.setText(outputStr + "\n" + "購買張數:"+ name +"張");
            }

        });

        CheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String outputStr = "";
                String name ="";
                name = EdtTicket.getText().toString();
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rdbBoy.isChecked())
                    outputStr += getResources().getString(R.string.male)+ "\n";
                else if (rdbGirl.isChecked())
                    outputStr += getResources().getString(R.string.female)+ "\n";

                RadioGroup rgType =(RadioGroup) findViewById(R.id.rgType);
                if(rgType.getCheckedRadioButtonId() == R.id.rdbAdult)
                    outputStr += getResources().getString(R.string.regularticket)+ "\n";
                else if(rgType.getCheckedRadioButtonId() == R.id.rdbChild)
                    outputStr += getResources().getString(R.string.childticket)+ "\n";
                else if(rgType.getCheckedRadioButtonId() == R.id.rdbStudent)
                    outputStr += getResources().getString(R.string.studentticket)+ "\n";
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(outputStr + "\n" + "購買張數:"+ name +"張");
                intent.putExtra("output", outputStr);
                intent.putExtra("ticket", name);
                startActivity(intent);
            }
        });

    }

}