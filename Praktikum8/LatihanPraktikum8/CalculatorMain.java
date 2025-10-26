
package com.mycompany.pixelcalculator;
import javax.swing.*;

public class CalculatorMain{
    public static void main(String args[]){
        SwingUtilities.invokeLater(() -> {
            new PixelCalculator().setVisible(true);
        });
    }
}

