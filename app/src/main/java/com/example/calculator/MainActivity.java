package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel2 calculator;

    private TextView inputField;
    private Button btnClear;
    private  Button getAnswer;

    private HashMap idToNumber = new HashMap<Integer, Character>();
    private HashMap idToOperator = new HashMap<Integer, Character>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idToNumber.put(R.id.btn_zero, '0');
        idToNumber.put(R.id.btn_one, '1');
        idToNumber.put(R.id.btn_two, '2');
        idToNumber.put(R.id.btn_there, '3');
        idToNumber.put(R.id.btn_four, '4');
        idToNumber.put(R.id.btn_five, '5');
        idToNumber.put(R.id.btn_six, '6');
        idToNumber.put(R.id.btn_seven, '7');
        idToNumber.put(R.id.btn_eight, '8');
        idToNumber.put(R.id.btn_nine, '9');

        idToOperator.put(R.id.add, '+');
        idToOperator.put(R.id.subtract, '-');
        idToOperator.put(R.id.divide, '/');
        idToOperator.put(R.id.multiply, '*');
        idToOperator.put(R.id.getAnswer, '=');
        idToOperator.put(R.id.clear, 'c');

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
        };

        getAnswer = findViewById(R.id.getAnswer);
        btnClear = findViewById(R.id.clear);// fixme clear
        inputField = findViewById(R.id.input_field);
        calculator = new CalculatorModel2();

        inputField.setText(calculator.getValue());

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onClearPressed((Character) idToOperator.get(view.getId()));
                inputField.setText(calculator.getValue());
            }
        });

        getAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onOperatorEquals((Character) idToOperator.get(R.id.getAnswer));
                inputField.setText(calculator.getString());
            }
        });


        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumberClick((Character) idToNumber.get(view.getId()));
                inputField.setText(calculator.getString());
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onOperatorClick((Character) idToOperator.get(view.getId()));
                inputField.setText(calculator.getValue());
            }
        };

        for (int number : numbers) {
            findViewById(number).setOnClickListener(numberButtonClickListener);
        }

        for (int j : operation) {
            findViewById(j).setOnClickListener(actionButtonClickListener);
        }
    }

}
