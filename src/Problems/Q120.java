package Problems;

import java.util.List;

public class Q120 {
    int m;
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        dp = new Integer[m][m];
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int row, int col) {
        if(row==m){
            return 0;
        }
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        int left = helper(triangle,row+1,col);
        int right = helper(triangle,row+1,col+1);
        return dp[row][col]=triangle.get(row).get(col) + Math.min(left,right);

    }

}
