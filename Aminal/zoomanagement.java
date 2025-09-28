//wap in java to use swing components to implementthe CRUD applications for a zoo management system

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class zoomanagement extends JFrame {

    // Defining UI components
    private JTextField animalNameField, animalTypeField, animalAgeField;
    private JTextArea displayArea;
    private JButton addButton, viewButton, updateButton, deleteButton;
    private Map<Integer, Animal> animalDatabase = new HashMap<>();
    private int currentId = 1;

    public zoomanagement() {
        // Set frame properties
        setTitle("Zoo Management System");
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Panel for form input
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Animal Name:");
        JLabel typeLabel = new JLabel("Animal Type:");
        JLabel ageLabel = new JLabel("Animal Age:");

        animalNameField = new JTextField();
        animalTypeField = new JTextField();
        animalAgeField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(animalNameField);
        inputPanel.add(typeLabel);
        inputPanel.add(animalTypeField);
        inputPanel.add(ageLabel);
        inputPanel.add(animalAgeField);

        // Buttons for CRUD operations
        addButton = new JButton("Add Animal");
        viewButton = new JButton("View Animals");
        updateButton = new JButton("Update Animal");
        deleteButton = new JButton("Delete Animal");

        // Text area for displaying animals
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Adding components to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button listeners for CRUD operations
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAnimals();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimal();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAnimal();
            }
        });
    }

    // Method to add an animal
    private void addAnimal() {
        String name = animalNameField.getText();
        String type = animalTypeField.getText();
        String age = animalAgeField.getText();

        if (name.isEmpty() || type.isEmpty() || age.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.");
            return;
        }

        try {
            int ageInt = Integer.parseInt(age);
            Animal animal = new Animal(currentId++, name, type, ageInt);
            animalDatabase.put(animal.getId(), animal);
            JOptionPane.showMessageDialog(this, "Animal added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number.");
        }
    }

    // Method to view all animals
    private void viewAnimals() {
        StringBuilder sb = new StringBuilder();
        for (Animal animal : animalDatabase.values()) {
            sb.append(animal).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    // Method to update an animal
    private void updateAnimal() {
        String idInput = JOptionPane.showInputDialog(this, "Enter Animal ID to update:");
        if (idInput != null) {
            try {
                int id = Integer.parseInt(idInput);
                if (animalDatabase.containsKey(id)) {
                    Animal animal = animalDatabase.get(id);
                    animalNameField.setText(animal.getName());
                    animalTypeField.setText(animal.getType());
                    animalAgeField.setText(String.valueOf(animal.getAge()));

                    int response = JOptionPane.showConfirmDialog(this, "Do you want to update this animal?", "Update", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        animal.setName(animalNameField.getText());
                        animal.setType(animalTypeField.getText());
                        animal.setAge(Integer.parseInt(animalAgeField.getText()));
                        JOptionPane.showMessageDialog(this, "Animal updated successfully.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Animal ID not found.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid ID format.");
            }
        }
    }

    // Method to delete an animal
    private void deleteAnimal() {
        String idInput = JOptionPane.showInputDialog(this, "Enter Animal ID to delete:");
        if (idInput != null) {
            try {
                int id = Integer.parseInt(idInput);
                if (animalDatabase.containsKey(id)) {
                    animalDatabase.remove(id);
                    JOptionPane.showMessageDialog(this, "Animal deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Animal ID not found.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid ID format.");
            }
        }
    }

    // Animal class to represent animals in the zoo
    static class Animal {

        private int id;
        private String name;
        private String type;
        private int age;

        public Animal(int id, String name, String type, int age) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Type: " + type + ", Age: " + age;
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            zoomanagement frame = new zoomanagement();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
