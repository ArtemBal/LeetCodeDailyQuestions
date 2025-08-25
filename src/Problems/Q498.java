package Problems;

public class Q498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int i = 0;
        int j = 0;
        int index = 0;
        ans[index++] = mat[0][0];
        while(index < n * m) {
            while(i + 1 < n && j - 1 >= 0) {
                i++;
                j--;
                ans[index++] = mat[j][i];
            }
            if(i < n - 1) {
                i++;
                ans[index++] = mat[j][i];
            } else if(j < m - 1) {
                j++;
                ans[index++] = mat[j][i];
            }

            while(i - 1 >= 0 && j + 1 < m) {
                i--;
                j++;
                ans[index++] = mat[j][i];
            }
            if(j < m - 1) {
                j++;
                ans[index++] = mat[j][i];
            } else if(i < n - 1) {
                i++;
                ans[index++] = mat[j][i];
            }

        }
        return ans;
    }
}
