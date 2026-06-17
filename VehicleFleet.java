// Practice 11: Vehicle Fleet
// Uses inheritance and method overriding to calculate rental fees.

import java.util.ArrayList;

abstract class Vehicle {
    protected String name;
    protected int rentalDays;

    public Vehicle(String name, int rentalDays) {
        this.name = name;
        this.rentalDays = rentalDays;
    }

    // Bike and Bus will calculate this differently.
    public abstract double calculateFee();

    public void printFee() {
        System.out.printf("%s fee for %d days: Rs. %.2f%n", name, rentalDays, calculateFee());
    }
}

class Bike extends Vehicle {
    public Bike(String name, int rentalDays) {
        super(name, rentalDays);
    }

    @Override
    public double calculateFee() {
        return rentalDays * 500;
    }
}

class Bus extends Vehicle {
    public Bus(String name, int rentalDays) {
        super(name, rentalDays);
    }

    @Override
    public double calculateFee() {
        return rentalDays * 3000;
    }
}

public class VehicleFleet {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Bike("Mountain Bike", 3));
        fleet.add(new Bus("Tourist Bus", 2));
        fleet.add(new Bike("City Bike", 5));

        // The loop treats all objects as Vehicle, but each one uses its own fee logic.
        for (Vehicle vehicle : fleet) {
            vehicle.printFee();
        }
    }
}
