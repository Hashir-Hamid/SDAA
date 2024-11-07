/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BillGeneartion;

/**
 *
 * @author Hashir Hamid
 */
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private List<Item> items;

    // Constructor to initialize the item list
    public BillDAO() {
        items = new ArrayList<>();
    }

    // Add an item to the bill
    public void addItem(Item item) {
        items.add(item);
    }

    // Get all items
    public List<Item> getItems() {
        return items;
    }

    // Clear items after bill generation
    public void clearItems() {
        items.clear();
    }
}
