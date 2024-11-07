/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Report;

/**
 *
 * @author Hashir Hamid
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReportGUI extends JFrame {
    private ReportService reportService;
    private JTextArea reportArea;

    public ReportGUI() {
        reportService = new ReportService();
        setTitle("Restaurant Management System - Report");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Report Viewer", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JButton loadReportButton = new JButton("Load Reports");
        loadReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadReports();
            }
        });
        add(loadReportButton, BorderLayout.SOUTH);
    }

    private void loadReports() {
        reportArea.setText("");  // Clear existing text
        List<String> reports = reportService.fetchReports();
        for (String report : reports) {
            reportArea.append(report + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportGUI().setVisible(true);
            }
        });
    }
}
