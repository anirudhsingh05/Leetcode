class Solution {

    public static List<Integer> generateRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        long ans = 1;
        ansRow.add(1);
        for(int i=1;i<row;i++){
            ans = ans * (row-i);
            ans = ans / i;
            ansRow.add((int)ans);
        } 
        return ansRow;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
}