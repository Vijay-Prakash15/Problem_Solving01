package DP;

public class mcmArray {
    // public static void main(String[] args) {
    //     int[] arr = {10, 30, 5, 60};
    //     int n = arr.length;

    //     System.out.println("Min Cost = " + mcm(arr, 1, n - 1));
    //     // Output: Min Cost = 4500
    // }
    // // i = start matrix index (1-based)
    // // j = end matrix index
    // static int mcm(int[] arr, int i, int j) {

    //     // Base Case: single matrix → no multiplication needed
    //     if (i == j) return 0;

    //     int minCost = Integer.MAX_VALUE;

    //     // Try every split point k from i to j-1
    //     for (int k = i; k < j; k++) {

    //         int left     = mcm(arr, i, k);         // cost of left part
    //         int right    = mcm(arr, k + 1, j);     // cost of right part
    //         int multCost = arr[i-1] * arr[k] * arr[j]; // merge cost

    //         int total = left + right + multCost;
    //         minCost = Math.min(minCost, total);
    //     }

    //     return minCost;
    // }
    static int[][] dp;

    static int mcm(int[] arr, int i, int j) {

        // Base Case
        if (i == j) return 0;

        // Already computed? Return stored result
        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int left     = mcm(arr, i, k);
            int right    = mcm(arr, k + 1, j);
            int multCost = arr[i-1] * arr[k] * arr[j];

            int total = left + right + multCost;
            minCost = Math.min(minCost, total);
        }

        dp[i][j] = minCost;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        int n = arr.length;

        // Initialize dp table with -1 (uncomputed)
        dp = new int[n][n];
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        System.out.println("Min Cost = " + mcm(arr, 1, n - 1));
        // Output: Min Cost = 4500

        // Print dp table
        System.out.println("\nMemo Table:");
        for (int[] row : dp) {
            for (int val : row)
                System.out.printf("%8d", val);
            System.out.println();
        }
    }
}

// ### 📊 DP Table after Memoization
// ```
//         j=0     j=1     j=2     j=3
// i=0 [    -1,     -1,     -1,     -1 ]
// i=1 [    -1,      0,   1500,   4500 ]  ← answers stored here
// i=2 [    -1,     -1,      0,   9000 ]
// i=3 [    -1,     -1,     -1,      0 ]
// ```

// | Time | Space |
// |------|-------|
// | O(n³) | O(n²) table + O(n) stack |


