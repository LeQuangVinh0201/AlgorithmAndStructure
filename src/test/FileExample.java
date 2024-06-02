package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Prepare for Java Interview 2023\\A các kiến thức Java Cở bản nhất-07112022\\example123.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter myWriter = new FileWriter("D:\\Prepare for Java Interview 2023\\A các kiến thức Java Cở bản nhất-07112022\\example123.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

