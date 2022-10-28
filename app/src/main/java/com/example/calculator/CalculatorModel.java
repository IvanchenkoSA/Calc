package com.example.calculator;

import android.widget.Switch;

class CalculatorModel {

    int firstArg;
    int secondArg;

    StringBuilder inputStr = new StringBuilder();

    private State state = State.firstArgInput;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    private int actionSelected;

    public void onNumberPressed (int buttonId){

        if (state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.btn_zero:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.btn_one:
                    inputStr.append("1");
                    break;
                case R.id.btn_two:
                    inputStr.append("2");
                    break;
                case R.id.btn_there:
                    inputStr.append("3");
                    break;
                case R.id.btn_four:
                    inputStr.append("4");
                    break;
                case R.id.btn_five:
                    inputStr.append("5");
                    break;
                case R.id.btn_six:
                    inputStr.append("6");
                    break;
                case R.id.btn_seven:
                    inputStr.append("7");
                    break;
                case R.id.btn_eight:
                    inputStr.append("8");
                    break;
                case R.id.btn_nine:
                    inputStr.append("9");
                    break;
            }
        }
    }

    public void onActionPressed (int actionId){
        if (actionId == R.id.getAnswer && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.add:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.subtract:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.divide:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);

            switch (actionId) {
                case R.id.add:
                    actionSelected = R.id.add;
                    break;
                case R.id.subtract:
                    actionSelected = R.id.subtract;
                    break;
                case R.id.divide:
                    actionSelected = R.id.divide;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.getAnswer:
                    actionSelected = R.id.getAnswer;
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.resultShow) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.add:
                    actionSelected = R.id.add;
                    break;
                case R.id.subtract:
                    actionSelected = R.id.subtract;
                    break;
                case R.id.divide:
                    actionSelected = R.id.divide;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.getAnswer:
                    actionSelected = R.id.getAnswer;
                    break;
            }
        }
    }

    public String getText(){
        return inputStr.toString();
    }


    public void onCancelPressed(int id){
        if (id == R.id.cleans) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }
    }
}
