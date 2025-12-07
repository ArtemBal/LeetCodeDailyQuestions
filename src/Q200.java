public class Q200 {
    int count = 0;
    char[][] grid;
    int n;
    int m;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {
        grid[x][y] = '0';
        int[] dirs = {1, 0, -1, 0, 1};
        for(int i = 0; i < 4; i++) {
            int nextX = x + dirs[i];
            int nextY = y + dirs[i + 1];
            if(nextX < n && nextX >= 0 && nextY < m && nextY >= 0 && grid[nextX][nextY] == '1') {
                dfs(nextX, nextY);
            }
        }
    }
}
