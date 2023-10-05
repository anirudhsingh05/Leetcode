class Solution {

    public static boolean possible(int[] arr, int day, int m, int k){
        int count = 0;
        int NOB = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            } else {
                NOB += (count/k);
                count = 0;
            }
        }
        NOB += (count/k);
        if(NOB >= m){
            return true;
        } else {
            return false;
        }
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // edge case
        long val = (long)m*k;
        int n = bloomDay.length;
        if(n<val){
            return -1;
        }

        // max and min
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        //binary search
        int low = min;
        int high = max;

        while(low <= high){
            int mid = (low + high)/2;
            if(possible(bloomDay, mid, m, k)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}