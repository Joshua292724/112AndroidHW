package com.example.hw_counter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.lblOutput);
    }

    public void button_Click(View view) {
        count++;
        textView.setText(String.valueOf(count));
    }

    public void button2_Click(View view) {
        count = 0;
        textView.setText(String.valueOf(count));
    }

    public void button3_Click(View view) {
        count--;
        textView.setText(String.valueOf(count));
    }
}
