package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1765 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] ans = new int[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = isWater[i][j] - 1;
                if(ans[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[] directions = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            for(int k = 0; k < 4; k++) {
                int x = row + directions[k];
                int y = col + directions[k + 1];
                if(x >= 0 && x < n && y >= 0 && y < m && ans[x][y] == -1) {
                    ans[x][y] = ans[row][col] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }
}
