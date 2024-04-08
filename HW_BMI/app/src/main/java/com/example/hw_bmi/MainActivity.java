package com.example.hw_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow = findViewById(R.id.txtShow);
        txtShow.setTextSize(36);
        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText ediHeight = findViewById(R.id.editHeight);
        EditText ediWeight = findViewById(R.id.editWeight);

        if (v.getId() == R.id.btnCalc) {
            String heightStr = ediHeight.getText().toString();
            String weightStr = ediWeight.getText().toString();

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                txtShow.setText("请输入身高和体重");
                txtShow.setTextColor(Color.BLACK);
                return;
            }

            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);

            if (height <= 0 || weight <= 0) {
                txtShow.setText("身高和体重必须大于零");
                txtShow.setTextColor(Color.BLACK);
                return;
            }

            double bmi = weight / Math.pow(height / 100.0, 2);
            if (bmi >= 24)
                txtShow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txtShow.setTextColor(Color.BLUE);
            else
                txtShow.setTextColor(Color.GREEN);

            txtShow.setText(String.format("%.2f", bmi));
        } else {
            ediHeight.setText("");
            ediWeight.setText("");
            txtShow.setText("");
        }
    }
}
