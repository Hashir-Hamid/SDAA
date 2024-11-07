/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import java.util.List;

/**
 *
 * @author rehma
 */
public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private int nextOrderId = 1; // Starting ID

    // Method to generate a new order with an automatic ID
    public void placeOrder(String itemName, int quantity, double price) {
        Order order = new Order(nextOrderId++, itemName, quantity, price);
        orderDAO.addOrder(order);
        System.out.println("Order placed: " + order);
    }

    public Order getOrderDetails(int orderId) {
        return orderDAO.getOrderById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
