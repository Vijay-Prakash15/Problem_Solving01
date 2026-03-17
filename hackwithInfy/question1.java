
import java.util.Scanner;

public class question1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[][] queries = new int[q][4];
        for(int i=0;i<q;i++){
            for(int j=0;j<4;j++){
                queries[i][j] = sc.nextInt();
            }
        }
        int ans = sumOfAllQuery(arr, queries);
        System.out.print(ans);
    }
    public static int sumOfAllQuery(int[] arr, int[][] queries){
        int n = arr.length;
        int q = queries.length;
        int sum = 0;
        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];
            int y = queries[i][3];
            for(int j=l;j<=r;j++){
                arr[j] = x + (j-l)*y;
            }
        }
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        return sum;
    }
}