package slidingwinodw2Pointer;

import java.util.HashMap;

public class maxGoodSubarraySum {
    public static int  maximumGoodSubarray(int[] arr, int k){
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right =0;right<n;right++){
            sum += arr[right];
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while(map.size() > k){
                map.put(arr[left] , map.get(arr[left])-1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                sum -= arr[left];
                left++;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int n = 11;
        int k = 2;
        int[] arr = {1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1};
        int result = maximumGoodSubarray(arr, k);
        System.out.println(result);
    }

}
