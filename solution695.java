public class solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int a = area(grid, i, j);
                    res = Math.max(a, res);
                }
            }
        }
    }

    private int area(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;

        return 1
                + area(grid, i - 1, j)
                + area(grid, i + 1, j)
                + area(grid, i, j - 1)
                + area(grid, i, j + 1);
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }
}
