// Practice 14: Config Loader
// If config.txt is missing, the program creates it with default values.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigLoader {
    public static void main(String[] args) {
        try {
            readConfig();
        } catch (FileNotFoundException e) {
            // This is the main idea of the task: use the exception to trigger file creation.
            System.out.println("config.txt not found. Creating default config...");
            createDefaultConfig();
        }
    }

    private static void readConfig() throws FileNotFoundException {
        File file = new File("config.txt");

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Config loaded:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static void createDefaultConfig() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("config.txt"))) {
            writer.write("theme=light");
            writer.newLine();
            writer.write("language=en");
            writer.newLine();
            writer.write("autosave=true");
            writer.newLine();
            System.out.println("Default config.txt created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating config file: " + e.getMessage());
        }
    }
}
