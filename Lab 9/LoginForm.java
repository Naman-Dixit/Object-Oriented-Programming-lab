import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(300, 200);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 150, 25);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 150, 25);
        frame.add(passField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 30);
        frame.add(loginButton);

        JLabel message = new JLabel();
        message.setBounds(20, 140, 250, 25);
        frame.add(message);

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                message.setText("Login successful!");
            } else {
                message.setText("Invalid username or password.");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
