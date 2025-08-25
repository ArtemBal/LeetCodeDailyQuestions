package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> ans = new ArrayList<>(n * m);
        int i = 0;
        int j = 0;
        ans.add(mat[0][0]);
        while(ans.size() < n * m) {
            while(i + 1 < n && j - 1 >= 0) {
                i++;
                j--;
                ans.add(mat[j][i]);
            }
            if(i < n - 1) {
                i++;
                ans.add(mat[j][i]);
            } else if(j < m - 1) {
                j++;
                ans.add(mat[j][i]);
            }

            while(i - 1 >= 0 && j + 1 < m) {
                i--;
                j++;
                ans.add(mat[j][i]);
            }
            if(j < m - 1) {
                j++;
                ans.add(mat[j][i]);
            } else if(i < n - 1) {
                i++;
                ans.add(mat[j][i]);
            }

        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
