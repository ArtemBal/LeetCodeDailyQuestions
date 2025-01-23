package Problems;

public class Q1267 {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rCount = new int[r];
        int[] cCount = new int[c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1) {
                    rCount[i]++;
                    cCount[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1 && (rCount[i] > 1 || cCount[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
