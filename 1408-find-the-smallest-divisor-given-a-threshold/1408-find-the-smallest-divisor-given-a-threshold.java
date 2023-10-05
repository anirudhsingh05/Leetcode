class Solution {

    public static int sumD(int[] arr, int div){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        //edge case
        if(nums.length > threshold){
            return -1;
        } 

        // defining max for high value
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }

        // binary search on answer
        int low = 1;
        int high = max;

        while(low <= high){
            int mid = (low + high)/2;
            if(sumD(nums, mid) <= threshold){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}