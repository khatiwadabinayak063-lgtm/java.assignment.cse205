// Practice 4: Daily Sales Log
// Writes seven days of sales values into a text file.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DailySalesLog {
    public static void main(String[] args) {
        double[] sales = {1200.50, 985.75, 1340.00, 1125.25, 1560.90, 1780.40, 1499.99};
        String fileName = "weekly_sales.txt";

        // try-with-resources closes the writer automatically, even if something goes wrong.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double sale : sales) {
                writer.write(String.valueOf(sale));
                writer.newLine(); // one sale value per line
            }
            System.out.println("Weekly sales saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing sales file: " + e.getMessage());
        }
    }
}
