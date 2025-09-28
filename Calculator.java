import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    
    private JTextField display;
    private JLabel operatorDisplay; // New label to show current operator
    private double firstNumber;
    private double secondNumber;
    private String operation;
    private boolean isOperationClicked;
    
    // Color scheme
    private final Color DARK_GRAY = new Color(50, 50, 50);
    private final Color MEDIUM_GRAY = new Color(80, 80, 80);
    private final Color LIGHT_GRAY = new Color(120, 120, 120);
    private final Color ORANGE = new Color(255, 149, 0);
    private final Color TEXT_COLOR = new Color(230, 230, 230);
    private final Color DISPLAY_BG = new Color(30, 30, 30);
    
    public Calculator() {
        // Set up the frame
        setTitle("Calculator");
        setSize(320, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Set the look and feel to system default for better integration
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Main panel with a nice padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(DARK_GRAY);
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Display panel
        JPanel displayPanel = new JPanel(new BorderLayout(0, 5));
        displayPanel.setBackground(DARK_GRAY);
        displayPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        
        // Operator display label
        operatorDisplay = new JLabel(" ");
        operatorDisplay.setFont(new Font("Arial", Font.BOLD, 20));
        operatorDisplay.setForeground(ORANGE);
        operatorDisplay.setHorizontalAlignment(JLabel.RIGHT);
        operatorDisplay.setBorder(new EmptyBorder(0, 0, 5, 10));
        displayPanel.add(operatorDisplay, BorderLayout.NORTH);
        
        // Main display field with improved styling
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.PLAIN, 36));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(DISPLAY_BG);
        display.setForeground(TEXT_COLOR);
        display.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(MEDIUM_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        displayPanel.add(display, BorderLayout.CENTER);
        
        mainPanel.add(displayPanel, BorderLayout.NORTH);
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 8, 8));
        buttonPanel.setBackground(DARK_GRAY);
        
        // Button definitions with types for different styling
        String[][] buttons = {
            {"C", "CE", "%", "/"},
            {"7", "8", "9", "*"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"0", ".", "±", "="}
        };
        
        // Create and add buttons
        for (String[] row : buttons) {
            for (String label : row) {
                JButton button = createStyledButton(label);
                buttonPanel.add(button);
            }
        }
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
        
        // Initialize calculator state
        firstNumber = 0;
        secondNumber = 0;
        operation = "";
        isOperationClicked = false;
        
        setVisible(true);
    }
    
    // Create button with appropriate styling based on button type
    private JButton createStyledButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        
        // Style based on button type
        if (label.matches("[0-9]") || label.equals(".") || label.equals("±")) {
            button.setBackground(MEDIUM_GRAY);
            button.setForeground(TEXT_COLOR);
        } else if (label.equals("=")) {
            button.setBackground(ORANGE);
            button.setForeground(Color.WHITE);
        } else { // Operations and clear buttons
            button.setBackground(LIGHT_GRAY);
            button.setForeground(TEXT_COLOR);
        }
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (label.matches("[0-9]") || label.equals(".") || label.equals("±")) {
                    button.setBackground(new Color(100, 100, 100));
                } else if (label.equals("=")) {
                    button.setBackground(new Color(255, 170, 50));
                } else {
                    button.setBackground(new Color(140, 140, 140));
                }
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (label.matches("[0-9]") || label.equals(".") || label.equals("±")) {
                    button.setBackground(MEDIUM_GRAY);
                } else if (label.equals("=")) {
                    button.setBackground(ORANGE);
                } else {
                    button.setBackground(LIGHT_GRAY);
                }
            }
        });
        
        button.addActionListener(this);
        return button;
    }
    
    // Helper method to update operator display
    private void updateOperatorDisplay() {
        // Format operator display to show current calculation
        String formattedNumber = (firstNumber == (long) firstNumber) ? 
            String.format("%d", (long) firstNumber) : String.format("%s", firstNumber);
            
        operatorDisplay.setText(formattedNumber + " " + operation);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        // Handle numbers and decimal point
        if (command.matches("[0-9]") || command.equals(".")) {
            if (display.getText().equals("0") || isOperationClicked) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
            isOperationClicked = false;
        }
        
        // Handle operations
        else if (command.matches("[+\\-*/%]")) {
            try {
                firstNumber = Double.parseDouble(display.getText());
                operation = command;
                isOperationClicked = true;
                updateOperatorDisplay(); // Update operator display
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
        
        // Handle equals
        else if (command.equals("=")) {
            try {
                secondNumber = Double.parseDouble(display.getText());
                double result = calculateResult();
                
                // Format result to avoid unnecessary decimal places
                String resultText = (result == (long) result) ? 
                    String.format("%d", (long) result) : String.format("%s", result);
                
                display.setText(resultText);
                firstNumber = result;
                isOperationClicked = true;
                
                // Clear operator display after calculation is complete
                operatorDisplay.setText(" ");
                operation = "";
            } catch (NumberFormatException ex) {
                display.setText("Error");
            } catch (ArithmeticException ex) {
                display.setText("Error");
            }
        }
        
        // Handle clear all
        else if (command.equals("C")) {
            display.setText("0");
            operatorDisplay.setText(" "); // Clear operator display
            firstNumber = 0;
            secondNumber = 0;
            operation = "";
        }
        
        // Handle clear entry
        else if (command.equals("CE")) {
            display.setText("0");
        }
        
        // Handle sign change
        else if (command.equals("±")) {
            try {
                double number = Double.parseDouble(display.getText());
                number = -number;
                
                // Format number to avoid unnecessary decimal places
                String resultText = (number == (long) number) ? 
                    String.format("%d", (long) number) : String.format("%s", number);
                    
                display.setText(resultText);
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }
    
    private double calculateResult() {
        switch (operation) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstNumber / secondNumber;
            case "%":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }
                return firstNumber % secondNumber;
            default:
                return secondNumber;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}