package Problems;

import java.util.Arrays;

public class Q3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] cols = new int[2][n + 1];
        int[][] rows = new int[n + 1][2];
        Arrays.fill(cols[1], 0);
        Arrays.fill(cols[0], n + 1);
        for(int[] a: rows) {
            a[0] = n + 1;
            a[1] = 0;
        }
        for(int[] a: buildings) {
            int x = a[0];
            int y = a[1];
            cols[0][x] = Math.min(cols[0][x], y);
            cols[1][x] = Math.max(cols[1][x], y);
            rows[y][0] = Math.min(rows[y][0], x);
            rows[y][1] = Math.max(rows[y][1], x);
        }

        int ans = 0;
        for(int[] a: buildings) {
            int x = a[0];
            int y = a[1];
            if(x > rows[y][0] && x < rows[y][1] && y > cols[0][x] && y < cols[1][x]) {
                ans++;
            }
        }
        return ans;
    }
}
