import java.util.*;

public class StudentExamResultsAnalyzer {

    public static void main(String[] args) {
        // Creating a HashMap to store student names and their scores
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 78);
        studentScores.put("Charlie", 92);
        studentScores.put("Diana", 88);

        // Sorting the map by student name using TreeMap
        Map<String, Integer> sortedScores = new TreeMap<>(studentScores);

        // Displaying sorted student scores
        System.out.println("Student Exam Results (Sorted by Name):");
        for (Map.Entry<String, Integer> entry : sortedScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Finding the highest and lowest scores
        int highestScore = Collections.max(studentScores.values());
        int lowestScore = Collections.min(studentScores.values());

        System.out.println("\nHighest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);
    }
}
/*Program 10: Student Exam Results Analyzer (HashMap, TreeMap, Utility Classes)
Approach:
HashMap is used to store student names as keys and their exam scores as values.

TreeMap will store students' scores in sorted order based on their names.

Utility Classes such as Collections can be used to find the highest and lowest scores.

Explanation:
HashMap stores student names and their corresponding exam scores.

TreeMap is used to sort the student names alphabetically while keeping their scores intact.

The Collections.max() and Collections.min() methods are used to find the highest and lowest exam scores, respectively.
*/