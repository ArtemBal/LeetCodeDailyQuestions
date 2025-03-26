package Problems;

import java.util.Arrays;

public class Q2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        int reminder = grid[0][0] % x;
        for(int[] a: grid) {
            for(int i: a) {
                if(i % x != reminder) {
                    return -1;
                }
                arr[index++] = i;
            }
        }
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int operationCount = 0;
        for(int i: arr) {
            operationCount += Math.abs(median - i) / x;
        }
        return operationCount;
    }
}
