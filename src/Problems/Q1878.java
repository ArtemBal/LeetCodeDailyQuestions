package Problems;

import java.util.PriorityQueue;

public class Q1878 {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dirs = {-1, 1, 1, -1, -1};
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pq.size() < 3 && !pq.contains(grid[i][j])) {
                    pq.offer(grid[i][j]);
                } else if(grid[i][j] > pq.peek() && !pq.contains(grid[i][j])) {
                    pq.poll();
                    pq.offer(grid[i][j]);
                }
                int maxPossible = Math.min(Math.min(j, (n - i - 1) / 2), m - j - 1);
                for(int l = 1; l <= maxPossible; l++) {
                    int curr = 0;
                    for(int k = 0; k < 4; k++) {
                        int count = 0;
                        while(count < l) {
                            curr += grid[i][j];
                            j += dirs[k];
                            i += dirs[k + 1];
                            count++;
                        }
                    }
                    if(pq.size() < 3 && !pq.contains(curr)) {
                        pq.offer(curr);
                    } else if(curr > pq.peek() && !pq.contains(curr)) {
                        pq.poll();
                        pq.offer(curr);
                    }
                }
            }
        }
        int[] ans = new int[pq.size()];
        int index = pq.size() - 1;
        while(!pq.isEmpty() && index >= 0) {
            ans[index--] = pq.poll();
        }
        return ans;
    }
}
