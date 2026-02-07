
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair {

    int num;
    int cnt;

    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

}

public class no_Of_Ones_Binary {

    public static int count_Binary(int n) {
        if (n == 1) {
            return 1;
        }
        int ans = 0;
        while (n > 0) {
            int rem = n % 2;
            if (rem == 1) {
                ans++;
            }
            n = n / 2;
        }
        return ans;
    }

    public static int[] OneBinary(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.cnt != p2.cnt) {
                        return p2.cnt - p1.cnt;
                    }
                    return p2.num - p1.num;
                }
        );

        for (int i = 0; i < n; i++) {
            int binary_ones = count_Binary(arr[i]);
            pq.add(new Pair(arr[i], binary_ones));
        }
        int[] ans = new int[k];
        for(int i=0;i<k && !pq.isEmpty();i++){
            Pair p = pq.poll();
            ans[i] = p.num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner ic = new Scanner(System.in);
        int n = ic.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ic.nextInt();
        }
        int k = ic.nextInt();
        int[] ans = OneBinary(arr, k);
        for(int i=0;i<ans.length;i++){
            System.err.print(ans[i]+" ");
        }
    }
}
