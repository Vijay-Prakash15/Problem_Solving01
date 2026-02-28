package stackproblems;
import java.util.*;
public class nextSmallestEle {
    public static int[] nextSmallest(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {3,9,4,0,2};
        int[] res = nextSmallest(arr);
        System.out.println(Arrays.toString(res));
    }
}
