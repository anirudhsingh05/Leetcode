class Solution {

    public static int NOD(int[] arr, int cap){
        int days = 1;
        int load = 0;
        for(int i=0;i<arr.length;i++){
            if((load+arr[i]) > cap){
                days += 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        // low=max and high=sum of element in arrays
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        // binary search
        int low = max;
        int high = sum;
        while(low <= high){
            int mid = (low + high)/2;
            int day = NOD(weights, mid);
            if(day <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}