/*
You are given an array arr[] of size n containing positive integers and an integer x.

Your task is to find the maximum possible length k such that ALL subarrays of length k have sum less than or equal to x.

If there exists even one subarray of length k whose sum is greater than x, then that value of k is considered invalid.

Return the maximum valid value of k.

🔹 Input

An integer array arr[] of size n

An integer x

🔹 Output

An integer representing the maximum subarray length k satisfying the condition

*/

public class main {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 7, 9, 3, 4};
        int x = 16;
        System.out.print(helper(arr, x)); 
    }

    // Builds prefix sum and applies binary search
    public static int helper(int[] arr, int x) {
        int n = arr.length;

        // prefix sum array
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        return binarySearch(pre, x);
    }

    // Checks if ALL subarrays of length k have sum <= x
    public static boolean slidingWindow(int[] pre, int x, int k) {
        int n = pre.length;

        for (int i = 0; i <= n - k; i++) {
            int sum;
            if (i == 0) {
                sum = pre[k - 1];
            } else {
                sum = pre[i + k - 1] - pre[i - 1];
            }

            if (sum > x) {
                return false;   // ek bhi window fail => k invalid
            }
        }
        return true;  // all windows valid
    }

    // Binary search on answer (length k)
    public static int binarySearch(int[] pre, int x) {
        int low = 1, high = pre.length;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (slidingWindow(pre, x, mid)) {
                ans = mid;        // valid length
                low = mid + 1;   // try larger k
            } else {
                high = mid - 1;  // reduce k
            }
        }
        return ans;
    }
}
