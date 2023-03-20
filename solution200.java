public class solution200 {
    private int count = 0;

    public int numIslands(char[][] grid) {
        dfs(grid, 0, 0);
    }

    void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        count++;
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
