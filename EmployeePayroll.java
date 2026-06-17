// Practice 15: Employee Payroll
// Combines inheritance, ArrayList, method overriding, and file output.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    // Every employee type must define how their pay is calculated.
    public abstract double calculatePay();

    public String getPayrollLine() {
        return name + " -> Rs. " + String.format("%.2f", calculatePay());
    }
}

class FullTime extends Employee {
    private double monthlySalary;

    public FullTime(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}

class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

public class EmployeePayroll {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new FullTime("Maya", 60000));
        staff.add(new Contractor("Ram", 900, 45));
        staff.add(new FullTime("Sita", 75000));
        staff.add(new Contractor("Hari", 1200, 30));

        String fileName = "payroll_report.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Employee employee : staff) {
                // Polymorphism happens here: FullTime and Contractor calculate pay differently.
                String line = employee.getPayrollLine();
                writer.write(line);
                writer.newLine();
                System.out.println(line);
            }
            System.out.println("Payroll exported to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing payroll report: " + e.getMessage());
        }
    }
}
