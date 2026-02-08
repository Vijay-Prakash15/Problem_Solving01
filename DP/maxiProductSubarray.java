package DP;

public class maxiProductSubarray {
    public static int maximumProduct(int[] arr){
        int n = arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int curr = 1;
            for(int j=i;j<n;j++){
                curr = curr * arr[j];
                max = Math.max(max, curr);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.err.println("Maximum Product Subarray:- "+ maximumProduct(arr));
    }
}
