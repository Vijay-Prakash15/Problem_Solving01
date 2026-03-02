package DP;

public class MCM_Tabulation {

    static int mcm(int[] arr) {
        int n = arr.length;
        int N = n - 1;  // number of matrices

        // dp[i][j] = min cost to multiply matrices i..j
        int[][] dp = new int[n][n];
        // dp[i][i] = 0 by default (single matrix, no cost)

        // Fill table by increasing chain length L
        for (int L = 2; L <= N; L++) {           // chain length

            for (int i = 1; i <= N - L + 1; i++) { // start index
                int j = i + L - 1;               // end index

                dp[i][j] = Integer.MAX_VALUE;    // reset

                // Try every split point k
                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]               // left subchain
                             + dp[k+1][j]             // right subchain
                             + arr[i-1]*arr[k]*arr[j]; // merge cost

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // Print final table
        System.out.println("DP Table:");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                System.out.printf("%8d", dp[i][j]);
            System.out.println();
        }

        return dp[1][N]; // answer
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 5, 60};
        System.out.println("Min Cost = " + mcm(arr));
        // Output: Min Cost = 4500
    }
}

// ### 📊 Step-by-Step Table Filling

// **Input:** `arr = {10, 30, 5, 60}` → 3 matrices: A1(10×30), A2(30×5), A3(5×60)

// ---

// **STEP 1 — L=1 (Base Case):**
// ```
// dp[1][1] = 0   (A1 alone)
// dp[2][2] = 0   (A2 alone)
// dp[3][3] = 0   (A3 alone)
// ```

// ---

// **STEP 2 — L=2 (Pairs):**
// ```
// i=1, j=2 → k=1:
//   cost = dp[1][1] + dp[2][2] + arr[0]*arr[1]*arr[2]
//        =    0     +    0     + 10 × 30 × 5
//        = 1500
//   dp[1][2] = 1500  ✅

// i=2, j=3 → k=2:
//   cost = dp[2][2] + dp[3][3] + arr[1]*arr[2]*arr[3]
//        =    0     +    0     + 30 × 5 × 60
//        = 9000
//   dp[2][3] = 9000  ✅
// ```

// ---

// **STEP 3 — L=3 (Full Chain):**
// ```
// i=1, j=3 → try k=1 AND k=2:

//   k=1: cost = dp[1][1] + dp[2][3] + arr[0]*arr[1]*arr[3]
//             =    0     +   9000   + 10 × 30 × 60
//             = 0 + 9000 + 18000 = 27000

//   k=2: cost = dp[1][2] + dp[3][3] + arr[0]*arr[2]*arr[3]
//             =   1500   +    0     + 10 × 5 × 60
//             = 1500 + 0 + 3000 = 4500  ← MINIMUM ✅

//   dp[1][3] = min(27000, 4500) = 4500
// ```

// ---

// **Final DP Table:**
// ```
//         j=1     j=2     j=3
// i=1  [    0,   1500,   4500 ]
// i=2  [    0,      0,   9000 ]
// i=3  [    0,      0,      0 ]

// Answer = dp[1][3] = 4500 ✅
