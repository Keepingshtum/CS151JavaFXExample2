package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField displayField;

    private StringBuilder input = new StringBuilder();

    @FXML
    private void appendDigit(ActionEvent event) {
        Button button = (Button) event.getSource();
        input.append(button.getText());
        displayField.setText(input.toString());
    }

    @FXML
    private void appendOperator(ActionEvent event) {
        Button button = (Button) event.getSource();
        input.append(" ").append(button.getText()).append(" ");
        displayField.setText(input.toString());
    }

    @FXML
    private void clearDisplay() {
        input.setLength(0);
        displayField.clear();
    }

    @FXML
    private void calculateResult() {
        try {
            String expression = input.toString();
            String[] tokens = expression.split(" ");
            double result = Double.parseDouble(tokens[0]);

            for (int i = 1; i < tokens.length; i += 2) {
                String operator = tokens[i];
                double operand = Double.parseDouble(tokens[i + 1]);

                switch (operator) {
                    case "+":
                        result += operand;
                        break;
                    case "-":
                        result -= operand;
                        break;
                    case "*":
                        result *= operand;
                        break;
                    case "/":
                        result /= operand;
                        break;
                }
            }

            input.setLength(0);
            input.append(result);
            displayField.setText(input.toString());
        } catch (Exception e) {
            // Handle invalid expressions
            input.setLength(0);
            displayField.setText("Error");
        }
    }
}
