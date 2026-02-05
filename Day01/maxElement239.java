
import java.util.*;


public class maxElement239 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = maxInKWindow(arr, n, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    //using heap max



    // brute force
    public static int[] maxInKWindow(int[] arr, int n, int k) {

        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = arr[i];

            for (int j = i; j < i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            ans[i] = max;
        }

        return ans;
    }
}
