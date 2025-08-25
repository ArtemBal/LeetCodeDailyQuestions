package Problems;

public class Q3195 {
    public int minimumArea(int[][] grid) {
        int maxX = 0;
        int minX = 1001;
        int maxY = 0;
        int minY = 1001;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}
