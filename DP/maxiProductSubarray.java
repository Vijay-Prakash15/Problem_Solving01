package DP;

public class maxiProductSubarray {

    public static int maximumProduct(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = 1;
            for (int j = i; j < n; j++) {
                curr = curr * arr[j];
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static int maxProduct(int[] arr) {
        // code here
        int prd = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (pre == 0) {
                pre = 1;
            }
            if (suf == 0) {
                suf = 1;
            }

            pre *= arr[i];
            suf *= arr[n - 1 - i];
            prd = Math.max(prd, Math.max(pre, suf));
        }
        return prd;
    }

    public static int maxProductSub(int[] nums) {
        int n = nums.length;
        int maxEH = nums[0];
        int minEH = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = maxEH;
            maxEH = Math.max(nums[i],
                    Math.max(maxEH * nums[i], minEH * nums[i]));
            minEH = Math.min(nums[i],
                    Math.min(temp * nums[i], minEH * nums[i]));
            ans = Math.max(ans, maxEH);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.err.println("Maximum Product Subarray:- " + maxProductSub(arr));
    }
}
