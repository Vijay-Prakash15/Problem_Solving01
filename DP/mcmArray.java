package DP;

public class mcmArray {
    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        int n = arr.length;

        System.out.println("Min Cost = " + mcm(arr, 1, n - 1));
        // Output: Min Cost = 4500
    }
    // i = start matrix index (1-based)
    // j = end matrix index
    static int mcm(int[] arr, int i, int j) {

        // Base Case: single matrix → no multiplication needed
        if (i == j) return 0;

        int minCost = Integer.MAX_VALUE;

        // Try every split point k from i to j-1
        for (int k = i; k < j; k++) {

            int left     = mcm(arr, i, k);         // cost of left part
            int right    = mcm(arr, k + 1, j);     // cost of right part
            int multCost = arr[i-1] * arr[k] * arr[j]; // merge cost

            int total = left + right + multCost;
            minCost = Math.min(minCost, total);
        }

        return minCost;
    }
}
