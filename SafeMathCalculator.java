// Practice 7: Safe Math Calculator
// Handles divide-by-zero and wrong input type errors.

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeMathCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();

            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();

            // This line can throw ArithmeticException if b is zero.
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter integers only.");
        } finally {
            // Closing the scanner is a good habit when we are done using it.
            scanner.close();
        }
    }
}
