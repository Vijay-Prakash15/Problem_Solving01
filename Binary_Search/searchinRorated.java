package Binary_Search;

public class searchinRorated {
    public static int search(int[] nums, int target) {
        int pivot = findMin(nums);
        int idx = Bsearch(nums, 0, pivot - 1, target);
        if (idx != -1) return idx;
        return Bsearch(nums, pivot, nums.length - 1, target);
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        int mid = 0;
        while(left<right){
            mid = left + (right - left)/2;
            if(nums[mid]>nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public static int Bsearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.err.println("Search in rotated sorted array :- "+ search(nums, target));
    }
}
