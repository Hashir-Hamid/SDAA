/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

/**
 *
 * @author rehma
 */
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderAppGUI {
    private OrderService orderService = new OrderService();

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Restaurant Management System - Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JTextField itemNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(itemNameField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price per Item:"));
        inputPanel.add(priceField);

        JButton placeOrderButton = new JButton("Place Order");
        inputPanel.add(placeOrderButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Order List Panel
        JTextArea orderListArea = new JTextArea();
        orderListArea.setEditable(false);
        frame.add(new JScrollPane(orderListArea), BorderLayout.CENTER);

        // Event handling for "Place Order" button
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String itemName = itemNameField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());

                    orderService.placeOrder(itemName, quantity, price);

                    // Clear input fields
                    itemNameField.setText("");
                    quantityField.setText("");
                    priceField.setText("");

                    // Update order list display
                    displayAllOrders(orderListArea);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid input values.");
                }
            }
        });

        // Display all orders initially
        displayAllOrders(orderListArea);

        frame.setVisible(true);
    }

    private void displayAllOrders(JTextArea orderListArea) {
        List<Order> orders = orderService.getAllOrders();
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        orderListArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OrderAppGUI().createAndShowGUI();
        });
    }
}
