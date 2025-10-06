package Problems;

import java.util.*;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        Deque<int[]> pacificQueue = new LinkedList<>();
        Deque<int[]> atlanticQueue = new LinkedList<>();

        Set<Integer> pacificVisited = new HashSet<>();
        Set<Integer> atlanticVisited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    pacificVisited.add(i * m + j);
                    pacificQueue.offer(new int[]{i, j});
                }
                if(i == n - 1 || j == m - 1) {
                    atlanticVisited.add(i * m + j);
                    atlanticQueue.offer(new int[]{i, j});
                }
            }
        }

        bfs(heights, pacificVisited, pacificQueue);
        bfs(heights, atlanticVisited, atlanticQueue);

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int curr = i * m + j;
                if(pacificVisited.contains(curr) && atlanticVisited.contains(curr)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }

    private void bfs(int[][] heights, Set<Integer> visited, Deque<int[]> queue) {
        int[] dirs = {-1, 0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for(int i = 0; i < 4; i++) {
                int nextRow = row + dirs[i];
                int nextCol = col + dirs[i + 1];
                int nextEncoded = nextRow * heights[0].length + nextCol;
                if (nextRow >= 0 && nextRow < heights.length &&
                        nextCol >= 0 && nextCol < heights[0].length &&
                        !visited.contains(nextEncoded) &&
                        heights[nextRow][nextCol] >= heights[row][col]) {
                    visited.add(nextEncoded);
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }
    }
}
