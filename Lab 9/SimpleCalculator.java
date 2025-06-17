import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {
    private static JTextField textField;
    private static double num1 = 0, num2 = 0;
    private static char operator;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(400, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 40, 330, 50);
        frame.add(textField);

        String[] buttons = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "C", "=", "+"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(x, y, 80, 50);
            frame.add(btn);

            btn.addActionListener(e -> handleClick(e.getActionCommand()));

            x += 90;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void handleClick(String command) {
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': textField.setText("" + (num1 + num2)); break;
                case '-': textField.setText("" + (num1 - num2)); break;
                case '*': textField.setText("" + (num1 * num2)); break;
                case '/': textField.setText(num2 != 0 ? "" + (num1 / num2) : "Cannot divide by 0"); break;
            }
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }
}
