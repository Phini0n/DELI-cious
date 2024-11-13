package com.pluralsight.service;

import com.pluralsight.model.Order;
import com.pluralsight.view.Display;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileManagementService {

    // TODO: SET FILENAME FORMAT TO yyyyMMdd-hhmmss.txt
    private String timestamp = "";
    private File FILE = new File("receipts/");

    public String saveOrder(Order order, String timestamp) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE + timestamp));
        } catch (Exception e) {
            return "Error " + e;
        }
        return "Receipt creation successful in file location: " + getFileLocation();
    }

    public String getFileLocation() {
        return FILE.getAbsolutePath();
    }
}
