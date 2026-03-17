package stackproblems;

import java.util.Stack;

public class sum_of_subarray_minimum {
    public static void main(String[] aargs){
        int[] arr = {0,3,4,5,2,3,4,1,4};
        int x = sumSubarrayMins(arr);
        System.out.println(x);
    }
    public static int[] NSL(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] NSR(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = n;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = NSL(arr);
        int[] right = NSR(arr);
        long sum = 0;
        int M = 1000000007;
        for(int i=0;i<n;i++){
            long d1 = i - left[i];
            long d2 = right[i] - i;
            long totalWaysForIMin = d1 * d2;
            long sumIInTotalWays = arr[i] * totalWaysForIMin;

            sum = (sum + sumIInTotalWays) % M;
        }
        return (int)sum;
    }
}
