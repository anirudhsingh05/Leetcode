class Solution {

    public static int hours(int[] arr, int rate){
        int total = 0;
        for(int i=0;i<arr.length;i++){
            total += Math.ceil((double)arr[i] /(double) rate);
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];

        while(low <= high){
            int mid = (low + high)/2;
            int totalHours = hours(piles, mid);
            if(totalHours <= h){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}