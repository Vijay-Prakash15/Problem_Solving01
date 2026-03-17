package stackproblems;

import java.util.Stack;

public class sum_of_subarray_maximum {
    public static void main(String[] aargs){
        int[] arr = {4,-2,-3,4,1};
        int x = sumSubarrayMaxs(arr);
        System.out.println(x);
    }
    public static int[] NGL(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
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
    public static int[] NGR(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
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
    public static int sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] left = NGL(arr);
        int[] right = NGR(arr);
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
