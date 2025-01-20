package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> positions = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                positions.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowsCount = new int[m];
        int[] colsCount = new int[n];
        for(int i = 0; i < arr.length; i++) {
            int[] curr = positions.get(arr[i]);
            rowsCount[curr[0]]++;
            colsCount[curr[1]]++;
            if(rowsCount[curr[0]] == n|| colsCount[curr[1]] == m) {
                return i;
            }
        }
        return -1;
    }
}
