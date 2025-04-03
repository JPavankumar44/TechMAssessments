package org.example;
abstract class Product {
    protected String productName;
    protected double price;

    // Abstract method to be implemented by concrete classes
    public abstract void displayProductInfo();
    public abstract double calculateDiscount();
}

// Concrete class for Electronics
class Electronics extends Product {
    private int warrantyPeriod; // in years

    public Electronics(String productName, double price, int warrantyPeriod) {
        this.productName = productName;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    // Implement abstract methods
    @Override
    public void displayProductInfo() {
        System.out.println("Product: " + productName + ", Price: $" + price + ", Warranty Period: " + warrantyPeriod + " years");
    }

    @Override
    public double calculateDiscount() {
        if (warrantyPeriod > 2) {
            return price * 0.10; // 10% discount if warranty is more than 2 years
        }
        return 0;
    }
}

// Concrete class for Clothing
class Clothing extends Product {
    private String size;

    public Clothing(String productName, double price, String size) {
        this.productName = productName;
        this.price = price;
        this.size = size;
    }

    // Implement abstract methods
    @Override
    public void displayProductInfo() {
        System.out.println("Product: " + productName + ", Price: $" + price + ", Size: " + size);
    }

    @Override
    public double calculateDiscount() {
        if (size.equals("XL")) {
            return price * 0.15; // 15% discount for XL size
        }
        return 0;
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Electronics("Smartphone", 600, 3);
        Product product2 = new Clothing("T-Shirt", 30, "XL");

        // Display product info and calculate discount
        product1.displayProductInfo();
        System.out.println("Discount: $" + product1.calculateDiscount() + "\n");

        product2.displayProductInfo();
        System.out.println("Discount: $" + product2.calculateDiscount() + "\n");

        // Calculate the total cost
        double totalCost = (product1.price - product1.calculateDiscount()) + (product2.price - product2.calculateDiscount());
        System.out.println("Total Cost after Discounts: $" + totalCost);
    }
}

/*Explanation:
Abstract Class Product:

Defines common attributes (productName, price) and abstract methods (displayProductInfo, calculateDiscount) for all products.

Concrete Classes (Electronics, Clothing):

Implement the abstract methods specific to the product type.

Calculate a discount based on product-specific rules.

OnlineShoppingSystem Class:

Creates instances of products, displays their details, calculates discounts, and computes the total cost.

*/
