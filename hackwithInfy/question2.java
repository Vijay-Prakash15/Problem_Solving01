import java.util.Scanner;

public class question2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        long ans = operation2(A, B, x, y, z);
        System.out.print(ans);
    }
    public static long operation2(int[] A, int[] B, int x, int y, int z){        
        return helper(0, A, B, x, y, z);
    }
    public static long helper(int i, int[] A, int[] B, int x, int y, int z){
        int n = A.length;
        if(i == n) return 0;
        //option 1
        long op1 = -B[i] + helper(i+1, A, B, x,y,z);
        long op2 = Long.MIN_VALUE;
        long op3 = Long.MIN_VALUE;
        
        //option 2
        if(x>0 && y>0){
            op2 = (long)A[i] * (x-1) * (y-1) * z + helper(i+1, A, B, x-1, y-1, z);
        }
        //option 3
        if(y > 0 && z > 0){
            op3 = (long)A[i] * x * (y-1) * (z-1) + helper(i+1, A, B, x, y-1, z-1);
        }
        return Math.max(op1, Math.max(op2, op3));
    }
}