package Problems;

public class Q1975 {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        boolean negativeCount = false;
        long sum = 0;
        boolean zero = false;
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                if(temp < 0) {
                    negativeCount = !negativeCount;
                    temp = -temp;
                }
                if(temp == 0) {
                    zero = true;
                }
                sum += temp;
                min = Math.min(min, temp);
            }
        }
        if(zero || !negativeCount) {
            return sum;
        }
        return sum - min * 2L;
    }
}
