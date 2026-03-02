package DP;

public class mcm {
    public static void main(String[] args){
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 2}};
        int n = arr.length;
        int res = minMCM(arr, 0, n-1);
        System.out.print(res);
    }
    public static int minMCM(int[][] arr, int i, int j){
        if(i==j)return 0;
        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int x = arr[i][0] * arr[k][1] * arr[j][1];
            int totalCost = minMCM(arr, i, k) + minMCM(arr, k+1, j) + x;
            minCost = Math.min(minCost, totalCost);
        }
        return minCost;
    }
}
