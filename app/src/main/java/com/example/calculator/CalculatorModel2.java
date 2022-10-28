package com.example.calculator;

public class CalculatorModel2 {

    private double value = 0.0;

    private StringBuilder builder = new StringBuilder();

    void onNumberClick(char number) {

        if (number < '0' || number > '9') {
            throw new IllegalStateException(number + " not a number");
        }

        builder.append(number);
    }

    void onOperatorClick(char operator) {
        double number = Double.parseDouble(builder.toString());

        if (operator == '+') {
            value += number;
        } else if (operator == '-') {
            value -= number;
        }
    }

    String getValue() {
        return Double.toString(value);
    }
}
