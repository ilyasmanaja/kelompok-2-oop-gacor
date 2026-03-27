
package com.mycompany.pixelcalculator;

    import java.util.Objects;

public class CalculatorLogic {
    private double num1 = 0;
    private double num2 = 0;
    private char operator = '\u0000';
    private String layarAwal = "0";
    private boolean newCalculation = true;

    public String getLayarAwal() {
        return layarAwal;
    }

    public void processDigit(String digit) {
        if (newCalculation || Objects.equals(layarAwal, "0")) {
            layarAwal = digit;
            newCalculation = false;
        }   else {
            if (layarAwal.length() < 16) {
                layarAwal += digit;
            }
        }
    }

    public void processDecimal() {
        if (newCalculation) {
            layarAwal = "0.";
            newCalculation = false;
        }   else if (!layarAwal.contains(".")) {
            layarAwal += ".";
        }
    }

    public void processClear() {
        num1 = 0;
        num2 = 0;
        operator = '\u0000';
        layarAwal = "0";
        newCalculation = true;
    }

    public void processDelete() {
        if (layarAwal.length() > 1) {
            layarAwal = layarAwal.substring(0, layarAwal.length() - 1);
        }   else {
            layarAwal = "0";
            newCalculation = true;
        }
    }

    public void processToggleSign() {
        try {
            double value = Double.parseDouble(layarAwal);
            if (value != 0) {
                layarAwal = formatResult(value * -1);
            }
        }   catch (NumberFormatException e) {
            processClear();
            layarAwal = "Error";
        }
    }

    public void processPercent() {
        try {
            if (operator != '\u0000' && num1 != 0) {
                double percentValue = Double.parseDouble(layarAwal);
                num2 = (num1 * percentValue) / 100.0;
                layarAwal = formatResult(num2);
            }   else {
                double value = Double.parseDouble(layarAwal);
                layarAwal = formatResult (value / 100.0);
                newCalculation = true;
            }
        }   catch (NumberFormatException e) {
            processClear();
            layarAwal = "Error";
        }
    }

    public void processOperator(String operatorCommand) {
        try {
            if (!newCalculation && operator != '\u0000') {
                processEquals();
            }
            num1 = Double.parseDouble(layarAwal);
            operator = operatorCommand.charAt(0);
            newCalculation = true;
        }   catch (NumberFormatException e) {
            processClear();
            layarAwal = "Error";
        }
    }

    public void processEquals() {
        if (operator == '\u0000') {
            return;
        }

        try {
            num2 = Double.parseDouble(layarAwal);
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case  '-':
                    result = num1 - num2;
                    break;
                case  '*':
                    result = num1 * num2;
                    break;
                case  '/':
                    if (num2 == 0) {
                        layarAwal = "Error";
                        operator = '\u0000';
                        newCalculation = true;
                        return;
                    }   else {
                        result = num1 / num2;
                    }
                    break;
            }

            layarAwal = formatResult(result);
            num1 = result;
            operator = '\u0000';
            newCalculation = true;
        }   catch (NumberFormatException e) {
            processClear();
            layarAwal = "Error";
        }
    }

    public String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        }   else {
            return String.format("%s", result);
        }
    }
}


