/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BillGeneartion;

/**
 *
 * @author Hashir Hamid
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillGUI extends JFrame {
    private BillService billService;
    private JTextArea billArea;
    private JTextField nameField, priceField, quantityField;
    private JLabel totalLabel;

    public BillGUI() {
        billService = new BillService();

        // Setting up the frame
        setTitle("Restaurant Management System - Bill Generation");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Components
        JLabel nameLabel = new JLabel("Item Name:");
        nameField = new JTextField(20);

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField(10);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(5);

        JButton addButton = new JButton("Add Item");
        JButton generateBillButton = new JButton("Generate Bill");

        billArea = new JTextArea(10, 40);
        billArea.setEditable(false);

        totalLabel = new JLabel("Total: $0.00");

        // Panel for input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);

        // Panel for bill display and total
        JPanel billPanel = new JPanel();
        billPanel.setLayout(new BorderLayout());
        billPanel.add(new JScrollPane(billArea), BorderLayout.CENTER);
        billPanel.add(totalLabel, BorderLayout.SOUTH);

        // Add button actions
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                billService.addItem(name, price, quantity);
                displayBill();
            }
        });

        generateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double total = billService.calculateTotalBill();
                totalLabel.setText("Total: $" + String.format("%.2f", total));
                JOptionPane.showMessageDialog(null, "Bill Generated Successfully!");
                billService.clearBill();
                displayBill(); // Clear the displayed bill
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(billPanel, BorderLayout.CENTER);
        add(generateBillButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Display the bill in the JTextArea
    private void displayBill() {
        billArea.setText(""); // Clear previous items
        for (Item item : billService.getItems()) {
            billArea.append(item.getName() + " - $" + item.getPrice() + " x " + item.getQuantity() +
                    " = $" + item.getTotalPrice() + "\n");
        }
    }

    public static void main(String[] args) {
        new BillGUI();
    }
}
