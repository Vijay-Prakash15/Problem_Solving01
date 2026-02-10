package Binary_Search;
public class kokoeatingBana {
     public static int kokoEat(int[] piles, int h) {
        // code here
        int left = 1;
        int right = 0;
        for(int ele : piles){
            right = Math.max(ele, right);
        }
        //binary search
        while(left < right){
            int mid = left + (right - left)/2;
            if(canEatAllBan(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static boolean canEatAllBan(int[] piles, int mid, int h){
        int actualH = 0;
        for(int x : piles){
            actualH += x / mid;
            if(x % mid != 0){
                actualH++;
            }
        }
        return actualH <= h;
    }
    public static void main(String[] args) {
        int arr[] = {5,10,15,20};
        int h = 7;
        System.err.println("Min time to eat banana: "+ kokoEat(arr, h));
    }
}
