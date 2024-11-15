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
    private final File FILE_LOCATION = new File("receipts/");

    public String saveOrder(Order order) {
        order.setTime();
        String fileName = order.getTime().format(formatter) + ".txt";
        File file = new File(FILE_LOCATION, fileName);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(order.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            return "Error " + e;
        }
        return "\nReceipt creation successful in file location: " + getFileLocation();
    }

    public String getFileLocation() {
        return FILE_LOCATION.getAbsolutePath();
    }
}
