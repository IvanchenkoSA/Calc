package com.example.calculator;

import java.text.DecimalFormat;

public class CalculatorModel2 {

    private double value = 0.0;
    private double num2;
    private char op;
    private boolean initial = true;


    DecimalFormat d = new DecimalFormat("#.####");
    private final StringBuilder builder = new StringBuilder();

    void onNumberClick(char number) {
        if (number < '0' || number > '9') {
            throw new IllegalStateException(number + " not a number");
        }
        builder.append(number);
    }


    void onOperatorClick(char operator) {
        if (builder.length() == 0){
            op = operator;
            return;
        }
        double number = Double.parseDouble(builder.toString());
        if (initial) {
            op = operator;
            value = number;
            initial = false;
            builder.delete(0, builder.length());
        } else {
            if (operator == '+') {
                op = '+';
                value += Double.parseDouble(builder.toString());
                builder.delete(0, builder.length());
            } else if (operator == '-') {
                op = '-';
                value -= number;
                builder.delete(0, builder.length());
            } else if (operator == '*') {
                op = '*';
                value *= Double.parseDouble(builder.toString());
                builder.delete(0, builder.length());
            } else if (operator == '/') {
                op = '/';
                value /= Double.parseDouble(builder.toString());
                builder.delete(0, builder.length());
            }
        }
    }

    void onOperatorEquals(char opEquals) {
        if (opEquals == '=' && builder.length() > 0) {
            num2 = Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
            switch (op) {
                case '+':
                    builder.append(value + num2);
                    value = Double.parseDouble(builder.toString());
                    break;
                case '-':
                    builder.append(value - num2);
                    value = Double.parseDouble(builder.toString());
                    break;
                case '*':
                    builder.append(value * num2);
                    value = Double.parseDouble(builder.toString());
                    break;
                case '/':
                    builder.append(value / num2);
                    value = Double.parseDouble(builder.toString());
                    break;
            }
        }
        return;
    }

    void onClearPressed(char btnCleans) {
        if (btnCleans == 'c') {
            builder.delete(0, builder.length());
            value = 0.0;
            num2 = 0.0;
            initial = true;
            op = ' ';
        }
    }

    String getString() {
        return builder.toString();
    }

    String getValue() {
        return d.format(value);
    }
}
