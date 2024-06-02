package test;

import java.io.File;

public class DirectoryExample {
    public static void main(String[] args) {
        File directory = new File("D:\\Prepare for Java Interview 2023\\A các kiến thức Java Cở bản nhất-07112022\\Java Core");
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directory.getName());
        } else {
            System.out.println("Directory already exists or failed to create.");
        }

        // Listing files and directories
        File[] filesList = directory.listFiles();
        if (filesList != null) {
            for (File file : filesList) {
                if (file.isDirectory()) { // neu no la 1 thư mục 
                    System.out.println("Directory: " + file.getName());
                } else {
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}

