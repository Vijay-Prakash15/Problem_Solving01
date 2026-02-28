package Stack;
import java.util.*;
import java.util.Stack;
public class nextGreaterElement {
    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] res = nextGreater(arr);

        System.out.println(Arrays.toString(res));
    }
}
