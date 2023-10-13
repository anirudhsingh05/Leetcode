class Solution {

    public static boolean canWePlace(int[] arr, int force, int m){
        int count = 1;
        int last = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] - last >= force){
                count++;
                last = arr[i];
            }
            if(count >= m){
                return true;
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
       Arrays.sort(position);
       int low = 1;
       int high = position[position.length-1] - position[0];
       while(low <= high){
           int mid = (low + high)/2;
           if(canWePlace(position, mid, m)){
               low = mid + 1;
           } else {
               high = mid - 1;
           }
       } 
       return high;
    }
}