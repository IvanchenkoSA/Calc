package com.example.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

    public class CalculatorModel2 {

        private BigDecimal value = BigDecimal.ZERO;
        private BigDecimal num2 = BigDecimal.ZERO;
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
        BigDecimal number = new BigDecimal(builder.toString());
        if (initial) {
            op = operator;
            value = number;
            initial = false;
            builder.delete(0, builder.length());
        } else {
            if (operator == '+') {
                op = '+';
                value.add(new BigDecimal(builder.toString()));
                builder.delete(0, builder.length());
            } else if (operator == '-') {
                op = '-';
                value.subtract(new BigDecimal(builder.toString()));
                builder.delete(0, builder.length());
            } else if (operator == '*') {
                op = '*';
                value.multiply(new BigDecimal(builder.toString()));
                builder.delete(0, builder.length());
            } else if (operator == '/') {
                op = '/';
                value.divide(new BigDecimal(builder.toString()));
                builder.delete(0, builder.length());
            }
        }
    }

    void onOperatorEquals(char opEquals) {
        if (opEquals == '=' && builder.length() > 0) {
            num2 = new BigDecimal(builder.toString());
            builder.delete(0, builder.length());
            switch (op) {
                case '+':
                    builder.append(value.add(num2));
                    value = new BigDecimal(builder.toString());
                    break;
                case '-':
                    builder.append(value.subtract(num2));
                    value = new BigDecimal(builder.toString());
                    break;
                case '*':
                    builder.append(value.multiply(num2));
                    value = new BigDecimal(builder.toString());
                    break;
                case '/':
                    builder.append(value.divide(num2));
                    value = new BigDecimal(builder.toString());
                    break;
            }
        }
        return;
    }

    void onClearPressed(char btnCleans) {
        if (btnCleans == 'c') {
            builder.delete(0, builder.length());
            value = BigDecimal.ZERO;
            num2 = BigDecimal.ZERO;
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
