package com.example.radiobutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 获取 textView7
        TextView textView7 = findViewById(R.id.textView2);

        // 获取从 MainActivity 传递过来的结果
        String result = getIntent().getStringExtra("result");

        // 设置结果到 textView7 中
        textView7.setText(result);

        // 获取 btnclose 按钮
        Button btnclose = findViewById(R.id.btnclose);

        // 设置 btnclose 按钮的点击事件监听器
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建一个 Intent，用于返回到 MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                // 启动 MainActivity
                startActivity(intent);
                // 关闭当前的 MainActivity2
                finish();
            }
        });
    }
}