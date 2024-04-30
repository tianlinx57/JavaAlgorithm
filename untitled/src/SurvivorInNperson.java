import java.util.Scanner;

public class SurvivorInNperson {
    public static int findSurvivor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be a positive integer");
        }

        // Initialize an array to represent the circle of people
        boolean[] circle = new boolean[n];
        for (int i = 0; i < n; i++) {
            circle[i] = true; // true indicates the person is still in the circle
        }

        int count = 0; // Counter for counting the numbers
        int index = 0; // Index to iterate over the circle array

        // Keep eliminating people until only one is left
        while (count < n - 1) {
            for (int i = 0; i < 3; i++) {
                while (!circle[index]) {
                    // Skip over people who are already eliminated
                    index = (index + 1) % n;
                }
                index = (index + 1) % n; // Move to the next person
            }
            circle[(index - 1 + n) % n] = false; // Eliminate the person who reached count 3
            count++;
        }

        // Find the survivor
        for (int i = 0; i < n; i++) {
            if (circle[i]) {
                return i + 1; // Return the original index (adding 1 because of 0-based indexing)
            }
        }

        // This line should never be reached
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people in the circle: ");
        int n = scanner.nextInt();
        scanner.close();

        int survivor = findSurvivor(n);
        System.out.println("The survivor is at position: " + survivor);
    }
}
