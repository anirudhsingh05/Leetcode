class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int more = target - a;
            if(hash.containsKey(more)){
                ans[0] = hash.get(more);
                ans[1] = i;
                return ans;
            }
            hash.put(a, i);
        }
        return ans;
    }
}