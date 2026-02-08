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
    public static int maxProduct(int[] arr) {
        // code here
        int prd = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;
            
            pre *= arr[i];
            suf *= arr[n-1-i];
            prd = Math.max(prd, Math.max(pre, suf));
        }
        return prd;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 10, 2};
        System.err.println("Maximum Product Subarray:- "+ maxProduct(arr));
    }
}
