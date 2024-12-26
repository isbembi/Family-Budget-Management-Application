package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;

public class UserView {
    private JFrame frame;
    private JTextField nameField, emailField, passwordField, userTypeField, salaryField;

    public UserView() {
        frame = new JFrame("Add User");
        frame.setLayout(new GridLayout(6, 2));
        frame.setSize(400, 250);

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JTextField();
        userTypeField = new JTextField();
        salaryField = new JTextField();

        JButton addButton = new JButton("Add User");
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String userType = userTypeField.getText();
            int salary = Integer.parseInt(salaryField.getText());
            UserController.addUser(name, email, password, userType, salary);
        });

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(new JLabel("User Type:"));
        frame.add(userTypeField);
        frame.add(new JLabel("Salary:"));
        frame.add(salaryField);
        frame.add(addButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
