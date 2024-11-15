package com.pluralsight.service;

import com.pluralsight.model.Order;
import com.pluralsight.view.Display;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManagementService {

    // TODO: SET FILENAME FORMAT TO yyyyMMdd-hhmmss.txt
    private LocalDateTime timestamp;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    private File FILE = new File("receipts/");

    public String saveOrder(Order order) {
        order.setTime();
        String fileName = order.getTime().format(formatter);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE + fileName));
            bufferedWriter.write(order.toString());
        } catch (Exception e) {
            return "Error " + e;
        }
        return "Receipt creation successful in file location: " + getFileLocation();
    }

    public String getFileLocation() {
        return FILE.getAbsolutePath();
    }
}
