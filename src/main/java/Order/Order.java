/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

/**
 *
 * @author rehma
 */
public class Order {
    private int orderId;
    private String itemName;
    private int quantity;
    private double price;

    // Constructor, getters, and setters
    public Order(int orderId, String itemName, int quantity, double price) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Item: " + itemName + ", Quantity: " + quantity + ", Total: $" + calculateTotal();
    }
}
