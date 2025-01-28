package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q2658 {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] directions = {-1, 0, 1, 0, -1};
        int maxFish = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] > 0 && !visited[i][j]) {
                    int currFish = 0;
                    Deque<int[]> d = new ArrayDeque<>();
                    d.add(new int[]{i, j});
                    while(!d.isEmpty()) {
                        int[] arr = d.poll();
                        int r = arr[0];
                        int c = arr[1];
                        if(!visited[r][c]) {
                            currFish += grid[r][c];
                            visited[r][c] = true;
                        }
                        for(int k = 0; k < 4; k++) {
                            int x = r + directions[k];
                            int y = c + directions[k + 1];
                            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 0 && !visited[x][y]) {
                                d.offer(new int[]{x, y});
                            }
                        }
                    }
                    maxFish = Math.max(maxFish, currFish);
                }
            }
        }
        return maxFish;
    }
}
