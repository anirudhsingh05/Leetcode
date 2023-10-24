class Solution {

    private int dfs(int row, int col, int[][] grid, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col >= n) {
            return 0;
        }

        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        int currentVal = grid[row][col];
        int maxPath = 0;

        // Explore the three possible moves
        for (int dr = -1; dr <= 1; dr++) {
            int newRow = row + dr;
            int newCol = col + 1;

            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > currentVal) {
                maxPath = Math.max(maxPath, dfs(newRow, newCol, grid, dp) + 1);
            }
        }

        dp[row][col] = maxPath;
        return maxPath;
    }

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize a 2D array to store the maximum moves from each cell
        int[][] dp = new int[m][n];

        int maxMoves = 0;

        // Iterate through each cell in the first column
        for (int row = 0; row < m; row++) {
            maxMoves = Math.max(maxMoves, dfs(row, 0, grid, dp));
        }

        return maxMoves;
    }
}