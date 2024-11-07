/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BillGeneartion;

import java.util.List;

public class BillService {
    private BillDAO billDAO;

    public BillService() {
        billDAO = new BillDAO();
    }

    // Add item to the bill
    public void addItem(String name, double price, int quantity) {
        Item item = new Item(name, price, quantity);
        billDAO.addItem(item);
    }

    // Calculate the total bill amount
    public double calculateTotalBill() {
        double total = 0;
        for (Item item : billDAO.getItems()) {
            total += item.getTotalPrice();
        }
        return total;
    }

    // Get all items for display in the bill
    public List<Item> getItems() {
        return billDAO.getItems();
    }

    // Clear the items after bill generation
    public void clearBill() {
        billDAO.clearItems();
    }
}
