package com.example.hw_caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

enum State {FirstNumberInput, OperatorInputed, NumberInput}
enum OP { None, Add, Sub, Mul, Div}

public class MainActivity extends AppCompatActivity {

    private String operand1 = "0";
    private String operand2 = "0";
    private OP op = OP.None;
    private State state = State.FirstNumberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    public void processKeyInput(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        EditText editText = findViewById(R.id.display);

        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                handleNumberInput(buttonText);
                break;
            case ".":
                handleDecimalInput();
                break;
            case "Clear":
                clear();
                break;
            case "Back":
                handleBackspace();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                handleOperator(buttonText);
                break;
            case "=":
                calculateResult();
                break;
        }
        editText.setText(operand1);
    }

    private void handleNumberInput(String number) {
        switch (state) {
            case FirstNumberInput:
                operand1 = operand1.equals("0") ? number : operand1 + number;
                break;
            case OperatorInputed:
                operand2 = number;
                state = State.NumberInput;
                break;
            case NumberInput:
                operand2 = operand2.equals("0") ? number : operand2 + number;
                break;
        }
    }

    private void handleDecimalInput() {
        switch (state) {
            case FirstNumberInput:
                operand1 = operand1.contains(".") ? operand1 : operand1 + ".";
                break;
            case OperatorInputed:
                operand2 = operand2.contains(".") ? operand2 : operand2 + ".";
                state = State.NumberInput;
                break;
            case NumberInput:
                operand2 = operand2.contains(".") ? operand2 : operand2 + ".";
                break;
        }
    }

    private void clear() {
        operand1 = "0";
        operand2 = "0";
        op = OP.None;
        state = State.FirstNumberInput;
    }

    private void handleBackspace() {
        switch (state) {
            case FirstNumberInput:
                operand1 = operand1.length() > 1 ? operand1.substring(0, operand1.length() - 1) : "0";
                break;
            case NumberInput:
                operand2 = operand2.length() > 1 ? operand2.substring(0, operand2.length() - 1) : "0";
                break;
        }
    }

    private void handleOperator(String operator) {
        if (state == State.NumberInput || state == State.OperatorInputed) {
            calculateResult();
        }

        switch (operator) {
            case "+":
                op = OP.Add;
                break;
            case "-":
                op = OP.Sub;
                break;
            case "*":
                op = OP.Mul;
                break;
            case "/":
                op = OP.Div;
                break;
        }
        state = State.OperatorInputed;
    }

    private void calculateResult() {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);

        switch (op) {
            case Add:
                operand1 = String.valueOf(num1 + num2);
                break;
            case Sub:
                operand1 = String.valueOf(num1 - num2);
                break;
            case Mul:
                operand1 = String.valueOf(num1 * num2);
                break;
            case Div:
                if (num2 == 0) {
                    Toast.makeText(this, "除数不能为0", Toast.LENGTH_SHORT).show();
                    clear();
                    return;
                }
                operand1 = String.valueOf(num1 / num2);
                break;
        }
        operand2 = "0";
        state = State.NumberInput;
    }
}
