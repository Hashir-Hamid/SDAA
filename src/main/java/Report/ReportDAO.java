/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Report;

/**
 *
 * @author Hashir Hamid
 */
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    public List<String> getReports() {
        // Simulating data retrieval from a database
        List<String> reports = new ArrayList<>();
        reports.add("Sales Report: $5000");
        reports.add("Inventory Report: 20 items");
        reports.add("Customer Report: 50 visits");
        return reports;
    }
}
