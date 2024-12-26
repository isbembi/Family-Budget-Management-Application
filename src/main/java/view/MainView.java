package view;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private JFrame frame;

    public MainView() {
        frame = new JFrame("Family Budget Management");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton userButton = new JButton("Add User");
        JButton expenseButton = new JButton("Add Expense");
        JButton goalButton = new JButton("Add Goal");

        userButton.addActionListener(e -> new UserView());
        expenseButton.addActionListener(e -> new ExpenseView());
        goalButton.addActionListener(e -> new GoalView());

        frame.setLayout(new FlowLayout());
        frame.add(userButton);
        frame.add(expenseButton);
        frame.add(goalButton);

        frame.setVisible(true);
    }
}
