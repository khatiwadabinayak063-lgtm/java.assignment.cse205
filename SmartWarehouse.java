// Practice 1: Smart Warehouse
// This file shows how an abstract class and an interface can work together.

abstract class StorageUnit {
    // I kept these protected so the child class can use them directly.
    protected int id;
    protected double capacity;

    public StorageUnit(int id, double capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    // Every storage unit should know how to display its own details.
    public abstract void showDetails();
}

interface Refrigerated {
    // Any refrigerated unit must provide its own temperature adjustment logic.
    void adjustTemp(int temperature);
}

class ColdBox extends StorageUnit implements Refrigerated {
    private int currentTemperature;

    public ColdBox(int id, double capacity, int currentTemperature) {
        super(id, capacity); // send common data to the parent class
        this.currentTemperature = currentTemperature;
    }

    @Override
    public void adjustTemp(int temperature) {
        // In a real warehouse system, this could connect to a sensor or cooling machine.
        currentTemperature = temperature;
        System.out.println("ColdBox temperature adjusted to " + currentTemperature + "°C");
    }

    @Override
    public void showDetails() {
        System.out.println("ColdBox ID: " + id);
        System.out.println("Capacity: " + capacity + " liters");
        System.out.println("Current Temperature: " + currentTemperature + "°C");
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        // Small test object to prove inheritance and interface implementation are working.
        ColdBox box = new ColdBox(101, 500.5, 4);
        box.showDetails();
        box.adjustTemp(-2);
    }
}
