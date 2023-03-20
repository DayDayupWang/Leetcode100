import java.util.HashMap;
import java.util.HashSet;

public class solution827 {
    private HashMap<Integer, Integer> indexAndAreas = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int res = 0;
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 遍历岛屿格子
                if (grid[i][j] == 1) {
                    int area = area(grid, i, j, index);
                    // 标记岛屿下标
                    indexAndAreas.put(index++, area);
                    res = Math.max(res, area);
                }

            }
        }
        if (res == 0) {
            // res=0表示全图没有陆地，那么造一块，则返回1即可
            return 1;
        }
        /**
         * 遍历海洋格子，假设这个格子填充，那么就把上下左右是陆地的格子所在的岛屿连接起来
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 遍历海洋格子
                if (grid[i][j] == 0) {
                    // 对于一个海洋格子，把周围邻居的岛屿索引放进去
                    // 用set的目的是去重
                    HashSet<Integer> hashSet = findNeighbour(grid, i, j);
                    // 如果海洋格子周围没有格子不必计算
                    if (hashSet.size() < 1) {
                        continue;
                    }
                    int twoIsland = 1;
                    for (Integer k : hashSet) {
                        // 通过索引和面积的映射关系，可以得到填海造陆后的面积
                        twoIsland = twoIsland + indexAndAreas.get(k);
                        //再次比较res
                        res = Math.max(res, twoIsland);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 对于海洋格子，找到上下左右
     * 每个方向，都要确保有效inArea以及是陆地格子，则表示是该海洋格子的陆地邻居
     * 
     * @param grid
     * @param r
     * @param c
     * @return
     */
    private HashSet<Integer> findNeighbour(int[][] grid, int r, int c) {
        HashSet<Integer> hashSet = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] != 0)
            hashSet.add(grid[r - 1][c]);
        if (inArea(grid, r + 1, c) && grid[r + 1][c] != 0)
            hashSet.add(grid[r + 1][c]);
        if (inArea(grid, r, c - 1) && grid[r][c - 1] != 0)
            hashSet.add(grid[r][c - 1]);
        if (inArea(grid, r, c + 1) && grid[r][c + 1] != 0)
            hashSet.add(grid[r][c + 1]);
        return hashSet;

    }

    /**
     * dfs方法，将格子填充为index，即表示这个格子属于哪个岛的
     * 计算岛屿面积，上下左右，当然这个可以优化的，因为不需要计算上面的，会有重复
     * 
     * @param grid
     * @param r
     * @param c
     * @param index
     * @return
     */
    private int area(int[][] grid, int i, int j, int index) {
        if (!inArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        // 设置当前格子为某个岛屿编号
        grid[i][j] = index;

        return 1
                + area(grid, i - 1, j, index)
                + area(grid, i, j - 1, index)
                + area(grid, i + 1, j, index)
                + area(grid, i, j + 1, index);
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

}
