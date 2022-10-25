package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator;

    private TextView inputField;

    private Button btnCleans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        int[] numbers = new int[]{
            R.id.btn_zero,
            R.id.btn_one,
            R.id.btn_two,
            R.id.btn_there,
            R.id.btn_four,
            R.id.btn_five,
            R.id.btn_six,
            R.id.btn_seven,
            R.id.btn_eight,
            R.id.btn_nine
        };

        int[] operation = new int[]{
                R.id.divide,
                R.id.multiply,
                R.id.add,
                R.id.subtract,
                R.id.getAnswer
        };

        btnCleans = findViewById(R.id.cleans);
        inputField = findViewById(R.id.input_field);

        calculator = new CalculatorModel();


        btnCleans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onCancelPressed(view.getId());
                inputField.setText(calculator.getText());
            }
        });


        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumberPressed(view.getId());
                inputField.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                inputField.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbers.length; i++){
            findViewById(numbers[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < operation.length; i++){
            findViewById(operation[i]).setOnClickListener(actionButtonClickListener);
        }
    }

}