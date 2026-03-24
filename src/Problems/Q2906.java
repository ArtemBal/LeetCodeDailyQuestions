package Problems;

public class Q2906 {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        final int MOD = 12345;
        int[] pref = new int[n * m];
        int[] suff = new int[n * m];
        long curr = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                pref[i * m + j] = (int)curr;
                curr = curr * grid[i][j] % MOD;
            }
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                suff[i * m + j] = (int)curr;
                curr = curr * grid[i][j] % MOD;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = pref[i * m + j] * suff[i * m + j] % MOD;
            }
        }
        return grid;
    }
}
