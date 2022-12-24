package com.example.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculatorModel2 {
        private BigDecimal finalAnswer = BigDecimal.ZERO;
        private BigDecimal value = BigDecimal.ZERO;
        private BigDecimal num2 = BigDecimal.ZERO;
        private char op;
        private boolean initial = true;
        private final StringBuilder builder = new StringBuilder();
        DecimalFormat d = new DecimalFormat("#.####");

        void onNumberClick(char number) {

            if (number < '0' || number > '9') {

                throw new IllegalStateException(number + " not a number");

            }

            builder.append(number);

        }

    String format(BigDecimal x) {

        NumberFormat formatter = new DecimalFormat("0.0E0");
        formatter.setMinimumFractionDigits(0);
        return formatter.format(x);

    }

    void onOperatorClick(char operator) {

        if (builder.length() == 0) {

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

                    if (op == '+') {

                        if (value.toString().length() >= 12) {

                            BigDecimal s = new BigDecimal(builder.toString());
                            builder.delete(0, builder.length());
                            builder.append(format(s));
                            value = new BigDecimal(builder.toString());

                            } else if (value.toString().length() < 12) {

                                value = value.add(new BigDecimal(builder.toString()));
                                builder.delete(0, builder.length());
                                op = operator;

                            }

                    } else if (op == '-') {

                            if (value.toString().length() >= 12) {

                                BigDecimal s = new BigDecimal(builder.toString());
                                builder.delete(0, builder.length());
                                builder.append(format(s));
                                value = new BigDecimal(builder.toString());

                                } else if (value.toString().length() < 12) {

                                value = value.subtract(new BigDecimal(builder.toString()));
                                builder.delete(0, builder.length());
                                op = operator;

                                }

                    } else if (op == '*') {

                            if (value.toString().length() >= 12) {

                                BigDecimal s = new BigDecimal(builder.toString());
                                builder.delete(0, builder.length());
                                builder.append(format(s));
                                value = new BigDecimal(builder.toString());

                                } else if (value.toString().length() < 12) {

                                    value = value.multiply(new BigDecimal(builder.toString()));
                                    builder.delete(0, builder.length());
                                    op = operator;

                                }

                    } else if (op == '/') {

                        value = value.divide(new BigDecimal(builder.toString()));
                        builder.delete(0, builder.length());
                        op = operator;

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

                    if (builder.length() >= 12) {

                        BigDecimal s = new BigDecimal(builder.toString());
                        builder.delete(0, builder.length());
                        builder.append(format(s));
                        value = new BigDecimal(builder.toString());

                    }

                    value = new BigDecimal(builder.toString());
                    break;

                case '-':

                    builder.append(value.subtract(num2));
                    if (builder.length() > 12) {

                        BigDecimal s = new BigDecimal(builder.toString());
                        builder.append(format(s));
                        value = new BigDecimal(builder.toString());

                    } else if (builder.length() < 12) {

                        value = new BigDecimal(builder.toString());

                    }
                    break;


                case '*':

                    builder.append(value.multiply(num2));
                    if (builder.length() > 12) {

                        BigDecimal s = new BigDecimal(builder.toString());
                        builder.delete(0, builder.length());
                        builder.append(format(s));
                        value = new BigDecimal(builder.toString());

                    }

                    value = new BigDecimal(builder.toString());
                    break;

                case '/':

                    if (num2.equals(BigDecimal.ZERO)) {

                        value = new BigDecimal(BigInteger.ZERO);
                        return;

                    }

                        value = new BigDecimal(builder.append(value.divide(num2, 2,  BigDecimal.ROUND_CEILING)).toString());
                        break;

            }

            initial = true;
            builder.delete(0, builder.length());

        }

        return;

    }

    void onClearPressed(char btnCleans) {

        if (btnCleans == 'c') {

            builder.delete(0, builder.length());
            finalAnswer = BigDecimal.ZERO;
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

        return value.toString();

    }
}




