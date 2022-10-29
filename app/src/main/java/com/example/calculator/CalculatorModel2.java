package com.example.calculator;

public class CalculatorModel2 {

    private double value = 0.0;
    private double num1;
    private double num2;
    private char op;

    private StringBuilder builder = new StringBuilder();

    private State state = State.firstArgInput;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }



    void onNumberClick(char number) {
        switch (number) {
            case '0':
                if (builder.length() != 0) {
                    builder.append("0");
                }
                break;
            case '1':
                builder.append("1");
                break;
            case '2':
                builder.append("2");
                break;
            case '3':
                builder.append("3");
                break;
            case '4':
                builder.append("4");
                break;
            case '5':
                builder.append("5");
                break;
            case '6':
                builder.append("6");
                break;
            case '7':
                builder.append("7");
                break;
            case '8':
                builder.append("8");
                break;
            case '9':
                builder.append("9");
                break;
        }


    }

    void onOperatorClick(char operator) {
        if (builder.length() > 0 && operator == '+') {
            op = '+';
            num1 += Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
        } else if (builder.length() > 0 && operator == '-') {
            op = '-';
            num1 -= Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
        } else if (builder.length() > 0 && operator == '*') {
            op = '*';
            num1 = Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
        } else if (builder.length() > 0 && operator == '/') {
            op = '/';
            num1 = Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
        }else if (builder.length() > 0 && operator == '=') {
            num2 += Double.parseDouble(builder.toString());
            builder.delete(0, builder.length());
            switch (op) {
                case '+':
                    builder.append(num1 + num2);
                    break;
                case '-':
                    builder.append(num1 - num2);
                    break;
                case '*':
                    builder.append(num1 * num2);
                    break;
                case '/':
                    builder.append(num1 / num2);
                    break;
            }
        }
    }


    void onClearPressed(char btnCleans){
        if (btnCleans == 'c'){
            builder.delete(0, builder.length());
            value = 0.0;
            num1 = 0.0;
            num2 = 0.0;
        }
    }


    String getString() {
        return builder.toString();
    }

    String getValue() {
        return Double.toString(value);
    }
}
