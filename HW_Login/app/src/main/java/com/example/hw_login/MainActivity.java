package com.example.hw_login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // 检查用户名和密码是否为空
                if (username.isEmpty()) {
                    // 用户名或密码为空，显示错误消息
                    Toast.makeText(MainActivity.this, "登入失敗! 請輸入帳號", Toast.LENGTH_SHORT).show();
                }
                else if (password.isEmpty()){
                    Toast.makeText(MainActivity.this, "登入失敗! 請輸入密碼", Toast.LENGTH_SHORT).show();
                }else{
                    String expectedUsername = "your_username";
                    String expectedPassword = "your_password";
                    Toast.makeText(MainActivity.this, "登入成功!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
