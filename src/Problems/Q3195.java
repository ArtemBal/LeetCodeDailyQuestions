package Problems;

public class Q3195 {
    public int minimumArea(int[][] grid) {
        int right = 0;
        int left = 1001;
        int top = 0;
        int bottom = 0;

        boolean flag = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    top = i;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        flag = false;
        for(int i = grid.length - 1; i >= 0 ; i--) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    bottom = i;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length && j < left; j++) {
                if(grid[i][j] == 1) {
                    left = Math.min(left, j);
                    break;
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = grid[0].length - 1; j >= 0 && j > right; j--) {
                if(grid[i][j] == 1) {
                    right = Math.max(right, j);
                    break;
                }
            }
        }

        return (bottom - top + 1) * (right - left + 1);
    }
}
