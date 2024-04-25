package com.example.hw_radiobutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNumber = findViewById(R.id.editTextNumber);
        final TextView lblOutput = findViewById(R.id.lblOutput);
        final Button button = findViewById(R.id.button);
        final Button confirmBtn = findViewById(R.id.confirmBtn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(editTextNumber.getText().toString());
                } catch (NumberFormatException e) {
                    lblOutput.setText("請輸入購買張數!");
                    return;
                }

                if (quantity == 0) {
                    lblOutput.setText("請輸入購買張數!");
                    return;
                }

                RadioButton rdbBoy = findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = findViewById(R.id.rdbGirl);
                String gender = "";
                if (rdbBoy.isChecked()) {
                    gender = getResources().getString(R.string.male);
                } else if (rdbGirl.isChecked()) {
                    gender = getResources().getString(R.string.female);
                }

                RadioGroup rgType = findViewById(R.id.rgType);
                int ticketPrice = 0;
                String ticketType = "";
                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    ticketType = getResources().getString(R.string.regularticket);
                    ticketPrice = 500;
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    ticketType = getResources().getString(R.string.childticket);
                    ticketPrice = 250;
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbStudent) {
                    ticketType = getResources().getString(R.string.studentticket);
                    ticketPrice = 400;
                }

                int totalCost = ticketPrice * quantity;

                String outputStr = String.format("%s\n%s: %d 張\n總金額 %d 元", gender, ticketType, quantity, totalCost);
                lblOutput.setText(outputStr);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在点击 confirm 按钮时启动 MainActivity2 并传递结果
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String outputStr = lblOutput.getText().toString();
                intent.putExtra("result", outputStr);
                startActivity(intent);
            }
        });
    }
}