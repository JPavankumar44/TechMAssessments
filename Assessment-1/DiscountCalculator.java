import java.util.Scanner;

public class DiscountCalculator {
    public static double calculateDiscount(double totalPrice) {
        double discount = 0;

        if (totalPrice >= 5000) {
            discount = 20;
        } else if (totalPrice >= 2000) {
            discount = 10;
        } else if (totalPrice >= 1000) {
            discount = 5;
        }

        double discountAmount = (totalPrice * discount) / 100;
        return totalPrice - discountAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total purchase amount: ");
        double totalPrice = scanner.nextDouble();

        double finalPrice = calculateDiscount(totalPrice);

        System.out.println("Final price after discount: " + finalPrice);

        scanner.close();
    }
}
/*Discount Calculator for an Online Store
Approach:
Define Discount Rules:

If total price ≥ 5000, apply a 20% discount.

If total price ≥ 2000, apply a 10% discount.

If total price ≥ 1000, apply a 5% discount.

Otherwise, no discount.

Steps to Implement:

Take user input for the total price.

Apply conditions to determine the discount percentage.

Calculate the final price after discount.*/