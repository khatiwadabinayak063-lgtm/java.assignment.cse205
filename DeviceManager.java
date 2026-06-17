// Practice 5: Device Manager
// Shows polymorphism with an abstract parent class and different devices.

abstract class ElectronicDevice {
    private String model;

    public ElectronicDevice(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    // Each device powers on differently, so child classes must define this.
    public abstract void powerOn();
}

class Printer extends ElectronicDevice {
    public Printer(String model) {
        super(model);
    }

    @Override
    public void powerOn() {
        System.out.println("Printer " + getModel() + " is warming up.");
    }
}

class Scanner extends ElectronicDevice {
    public Scanner(String model) {
        super(model);
    }

    @Override
    public void powerOn() {
        System.out.println("Scanner " + getModel() + " is ready to scan.");
    }
}

public class DeviceManager {
    public static void main(String[] args) {
        ElectronicDevice[] devices = {
                new Printer("HP-LaserJet"),
                new Scanner("Canon-ScanPro")
        };

        // Java decides at runtime which powerOn() version to call.
        for (ElectronicDevice device : devices) {
            device.powerOn();
        }
    }
}
