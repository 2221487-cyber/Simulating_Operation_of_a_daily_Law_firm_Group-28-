package com.example.simulating_operation_of_a_daily_law_firm_group28.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic file storage utility for reading and writing data to files
 */
public class FileStorage {
    private static final String STORAGE_DIR = "data/";

    static {
        // Create storage directory if it doesn't exist
        File dir = new File(STORAGE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * Write a list of strings to a file
     */
    public static void writeToFile(String filename, List<String> data) throws IOException {
        File file = new File(STORAGE_DIR + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Read all lines from a file
     */
    public static List<String> readFromFile(String filename) throws IOException {
        List<String> data = new ArrayList<>();
        File file = new File(STORAGE_DIR + filename);
        
        if (!file.exists()) {
            return data; // Return empty list if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }

    /**
     * Append a single line to a file
     */
    public static void appendToFile(String filename, String data) throws IOException {
        File file = new File(STORAGE_DIR + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine();
        }
    }

    /**
     * Check if a file exists
     */
    public static boolean fileExists(String filename) {
        File file = new File(STORAGE_DIR + filename);
        return file.exists();
    }

    /**
     * Delete a file
     */
    public static boolean deleteFile(String filename) {
        File file = new File(STORAGE_DIR + filename);
        return file.delete();
    }

    /**
     * Clear all content from a file
     */
    public static void clearFile(String filename) throws IOException {
        File file = new File(STORAGE_DIR + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Just open and close to clear the file
        }
    }
}
