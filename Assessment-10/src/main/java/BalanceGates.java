import java.util.PriorityQueue;

public class BalanceGates {
    public static void balanceGates(int[] arrivals, int numGates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Min-Heap [gateIndex, count]

        for (int i = 0; i < numGates; i++) {
            pq.offer(new int[]{i, 0}); // Initialize all gates with zero people
        }

        int[] gateUsage = new int[numGates];

        for (int i = 0; i < arrivals.length; i++) {
            int[] gate = pq.poll(); // Get the gate with the least usage
            gateUsage[gate[0]] += arrivals[i]; // Add people to that gate
            gate[1] += arrivals[i]; // Update usage count
            pq.offer(gate); // Push the updated gate back into the queue
        }

        // Print gate usage statistics
        for (int i = 0; i < numGates; i++) {
            System.out.println("Gate " + i + " handled " + gateUsage[i] + " people");
        }
    }

    public static void main(String[] args) {
        int[] arrivals = {5, 3, 4, 6, 8, 2, 10}; // Number of people arriving in sequence
        int numGates = 3;
        balanceGates(arrivals, numGates);
    }
}
/*Balance Gates Design
Problem Statement:
A factory has multiple gates through which employees enter and exit. The goal is to balance the gates so that an equal number of people use each gate over time.

Approach (Two Pointers + Greedy):
Maintain an array of gate counts to track how many people entered through each gate.

Assign new arrivals to the least-used gate to balance the distribution.

Use Min-Heap (Priority Queue) to always get the least-used gate in O(log n) time.

Time Complexity: O(n log k) (using PriorityQueue)
Space Complexity: O(k) (where k is the number of gates)*/