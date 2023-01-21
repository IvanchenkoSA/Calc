package com.example.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculatorModel2 {
    private BigDecimal result = BigDecimal.ZERO;
    private char op;
    private boolean initial = true;
    private final StringBuilder operand = new StringBuilder();

    // Обработка нажатий чисел
    void onNumberClick(char number) {

        if (number < '0' || number > '9') {

            throw new IllegalStateException(number + " not a number");

        }

        operand.append(number);

    }

    // Шаблон для вывода
    String format(BigDecimal x) {

        NumberFormat formatter = new DecimalFormat("0.0E0");
        formatter.setMinimumFractionDigits(0);
        return formatter.format(x);

    }

    // Обработка операций
    boolean onOperatorClick(char operator) {
        if (operand.length() == 0) {
            op = operator;
            return true;
        }
        BigDecimal number = new BigDecimal(operand.toString());
        if (initial) {
            op = operator;
            result = number;
            initial = false;
            operand.delete(0, operand.length());
            return false;
        } else {
            if (op == '+') {
                 {
                    result = result.add(new BigDecimal(operand.toString()));
                    operand.delete(0, operand.length());
                    op = operator;
                    initial = false;
                }
            } else if (op == '-') {
                if (result.toString().length() >= 12) {
                    BigDecimal s = new BigDecimal(operand.toString());
                    operand.delete(0, operand.length());
                    operand.append(format(s));
                    result = new BigDecimal(operand.toString());
                } else if (result.toString().length() < 12) {
                    result = result.subtract(new BigDecimal(operand.toString()));
                    operand.delete(0, operand.length());
                    op = operator;
                }
            } else if (op == '*') {
                if (result.toString().length() >= 12) {
                    BigDecimal s = new BigDecimal(result.toString());
                    operand.delete(0, operand.length());
                    operand.append(format(s));
                    result = result.multiply(new BigDecimal(operand.toString()));
                    operand.delete(0, operand.length());
                } else if (result.toString().length() < 12) {
                    result = result.multiply(new BigDecimal(operand.toString()));
                    operand.delete(0, operand.length());
                    op = operator;
                }
            } else if (op == '/') {
                result = result.divide(new BigDecimal(operand.toString()));
                operand.delete(0, operand.length());
                op = operator;
            }
            return true;
        }
    }

    // Обработка кнопки '='
    void onOperatorEquals(char opEquals) {
        if (opEquals == '=' && operand.length() > 0) {
            BigDecimal num2 = new BigDecimal(operand.toString());
            operand.delete(0, operand.length());
            switch (op) {
                case '+':
                    operand.append(result.add(num2));
                    result = new BigDecimal(operand.toString());
                    break;
                case '-':
                    operand.append(result.subtract(num2));
                    if (operand.length() >= 12) {
                        BigDecimal s = new BigDecimal(operand.toString());
                        operand.delete(0, operand.length());
                        operand.append(format(s));
                        result = new BigDecimal(operand.toString());
                    }
                        result = new BigDecimal(operand.toString());
                    break;
                case '*':
                    operand.append(result.multiply(num2));
                    if (operand.length() >= 12) {
                        BigDecimal s = new BigDecimal(operand.toString());
                        operand.delete(0, operand.length());
                        operand.append(format(s));
                        result = new BigDecimal(operand.toString());
                    }
                    result = new BigDecimal(operand.toString());
                    break;
                case '/':
                    if (num2.equals(BigDecimal.ZERO)) {
                        result = new BigDecimal(BigInteger.ZERO);
                        return;
                    }
                    result = new BigDecimal(operand.append(result.divide(num2, 2, BigDecimal.ROUND_CEILING)).toString());
                    break;
            }
//            initial = true;
            operand.delete(0, operand.length());
        }
        return;
    }

    // Обработка кнопки 'С' - очистить
    void onClearPressed(char btnCleans) {
        if (btnCleans == 'c') {
            operand.delete(0, operand.length());
            result = BigDecimal.ZERO;
            initial = true;
            op = ' ';
        }
    }

    String getOperand() {
        return operand.toString();
    }

    String getResult(boolean expFormat) {
            if (result.toString().length() >= 12 && expFormat) {
                return format(result);
            } else {
                return result.toString();
            }
    }
}




