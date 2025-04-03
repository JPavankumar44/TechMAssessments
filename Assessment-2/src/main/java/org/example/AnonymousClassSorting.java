package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousClassSorting {
    public static void main(String[] args) {
        // Array to be sorted
        Integer[] numbers = {5, 2, 8, 1, 3, 9, 6};

        // Sort using an anonymous class for ascending order comparison
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;  // Ascending order comparison
            }
        });

        // Print the sorted array
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(numbers));

        // Sort using an anonymous class for descending order comparison
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;  // Descending order comparison
            }
        });

        // Print the sorted array in descending order
        System.out.println("Sorted Array (Descending): " + Arrays.toString(numbers));
    }
}

