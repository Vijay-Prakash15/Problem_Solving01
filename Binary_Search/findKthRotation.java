package Binary_Search;
public class findKthRotation {
    public static int findMinIndex(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low < high){
            if(arr[low] <= arr[high]){
                return low;
            }
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[high]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        int min = findMinIndex(arr);
        return min;
    }
    public static void main(String[] args){
        int[] arr = {14, 17, 22, 41, 10};
        int ans = findKRotation(arr);
        System.err.println("Kth Rotation: "+ ans);
    }
}
