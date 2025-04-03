import java.util.HashMap;

public class GameOfThrones {
    public static String canFormPalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count characters with an odd frequency
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        // If more than 1 odd count, it can't form a palindrome
        return (oddCount > 1) ? "NO" : "YES";
    }

    public static void main(String[] args) {
        String s = "civic";
        System.out.println("Can form palindrome? " + canFormPalindrome(s));

        String s2 = "aabbccdde";
        System.out.println("Can form palindrome? " + canFormPalindrome(s2));
    }
}
/*
Game of Thrones (Palindrome Anagram Check)
Problem Statement:
Given a string, determine if its characters can be rearranged to form a palindrome.
If yes, return "YES", otherwise return "NO".

Approach (HashMap + Odd Count Check):
Even-length strings: All characters must appear an even number of times.

Odd-length strings: Only one character can appear an odd number of times.

Use a HashMap/Array to count occurrences of each character.
Time Complexity: O(n)
Space Complexity: O(1) (since we store only 26 characters max)*/