package Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        List<Integer> temp = new ArrayList<>(10);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                temp.add(grid[j][j + i]);
            }
            Collections.sort(temp);
            for(int j = 0; j < n - i; j++) {
                grid[j][j + i] = temp.get(j);
            }
            temp.clear();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                temp.add(grid[j + i][j]);
            }
            Collections.sort(temp, Collections.reverseOrder());
            for(int j = 0; j < n - i; j++) {
                grid[j + i][j] = temp.get(j);
            }
            temp.clear();
        }
        return grid;
    }
}
