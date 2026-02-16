
public class lc370 {
    public static void main(String[] args) {
        int len = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] result = getModifiedArray(len, updates);
        // Print the resulting array
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length]; // Initialize the difference array

        // Step 1: Apply updates using the difference array
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int x = update[2];

            diff[start] += x; // Add increment at startIndex
            if (end + 1 < length) {
                diff[end + 1] -= x; // Subtract increment after endIndex
            }
        }

        // Step 2: Compute the final array from the difference array
        int[] result = new int[length];
        int cumSum = 0;
        for (int i = 0; i < length; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }

        return result;
    }
}
