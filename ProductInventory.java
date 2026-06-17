// Practice 8: Product Inventory
// Applies a discount to every electronics item in an array.

interface Discountable {
    void applyDiscount(double percentage);
}

class Electronics implements Discountable {
    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void applyDiscount(double percentage) {
        // Simple validation so discount values stay realistic.
        if (percentage > 0 && percentage <= 100) {
            price -= price * percentage / 100;
        }
    }

    public void showProduct() {
        System.out.printf("%s -> Rs. %.2f%n", name, price);
    }
}

public class ProductInventory {
    public static void main(String[] args) {
        Electronics[] inventory = {
                new Electronics("Laptop", 85000),
                new Electronics("Phone", 45000),
                new Electronics("Headphones", 5000)
        };

        // Apply the same 10% discount to every product.
        for (Electronics item : inventory) {
            item.applyDiscount(10.0);
        }

        System.out.println("Inventory after 10% discount:");
        for (Electronics item : inventory) {
            item.showProduct();
        }
    }
}
