public class compi02 {
    public static void main(String[] args) {
        
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0){
            return false;
        }
        
        int n = grid.length;
        int[][] direction = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        
        int[][] step = new int[n * n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int id = grid[i][j];
                step[id][0] = i;
                step[id][1] = j;
            }
        }
        
        for(int i = 1; i < n * n; i++){
            int x1 = step[i - 1][0];
            int x2 = step[i][0];
            int y1 = step[i - 1][1];
            int y2 = step[i][1];
            
            boolean state = false;
            for(int j = 0; j < 8; j++){
                if(x1 + direction[j][0] == x2 && y1 + direction[j][1] == y2){
                    state = true;
                }
            }
            
            if(state == false){
                return false;
            }
        }
        
        return true;

    }
}
