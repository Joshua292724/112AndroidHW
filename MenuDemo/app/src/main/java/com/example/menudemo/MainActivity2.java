package com.example.menudemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView mainCourseTextView, sideDishTextView, drinksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainCourseTextView = findViewById(R.id.main_course_detail);
        sideDishTextView = findViewById(R.id.side_dish_detail);
        drinksTextView = findViewById(R.id.drinks_detail);

        // 获取传递过来的订单详情数据
        String mainCourse = getIntent().getStringExtra("mainCourse");
        String sideDish = getIntent().getStringExtra("sideDish");
        String drinks = getIntent().getStringExtra("drinks");

        // 设置订单详情文本
        mainCourseTextView.setText(mainCourse);
        sideDishTextView.setText(sideDish);
        drinksTextView.setText(drinks);
    }
}