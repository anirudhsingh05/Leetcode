class Solution {

    // private static int binary(int[] arr, int low, int high, int target){
    //     if(low>high){
    //         return -1;
    //     }
    //     int mid = (low+high)/2;
    //     if(arr[mid] == target){
    //         return mid;
    //     } else if(arr[mid] < target){
    //         return binary(arr, mid+1, high, target);
    //     } else {
    //         return binary(arr, low, mid-1, target);
    //     }
    // }

    public int search(int[] nums, int target) {
        //return binary(nums, 0, nums.length-1, target);

        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}