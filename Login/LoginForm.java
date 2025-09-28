import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField();

        JButton loginButton = new JButton("Login");

        // Add action listener for the login button
        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String pass = new String(passText.getPassword());

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Login Failed! Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(new JLabel()); // empty cell
        frame.add(loginButton);

        // Make frame visible
        frame.setVisible(true);
    }
}