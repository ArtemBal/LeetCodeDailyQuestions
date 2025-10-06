package Problems;

import java.util.PriorityQueue;

public class Q778 {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //queue for points {height, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currHeight = curr[0];
            //System.out.println()
            int currI = curr[1];
            int currJ = curr[2];
            for(int i = 0; i < 4; i++) {
                int nextI = currI + dirs[i];
                int nextJ = currJ + dirs[i + 1];
                if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
                    int nextHeight = grid[nextI][nextJ];
                    if(nextHeight < currHeight) {
                        grid[nextI][nextJ] = currHeight;
                        nextHeight = currHeight;
                    }
                    pq.offer(new int[]{nextHeight, nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
