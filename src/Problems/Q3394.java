package Problems;

import java.util.Arrays;

public class Q3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return helper(rectangles, 0) || helper(rectangles, 1);
    }

    private boolean helper(int[][] rectangles, int index) {
        Arrays.sort(rectangles, (a, b) -> a[index] - b[index]);
        int countRect = 0;
        int countCut = 0;
        int last = -1;
        for(int[] arr: rectangles) {
            int start = arr[index];
            int end = arr[index + 2];
            if(countRect > 0 && start >= last) {
                countCut++;
                if(countCut >= 2) {
                    return true;
                }
                countRect = 0;
            }
            if(end > last) {
                last = end;
            }
            countRect++;

        }
        return false;
    }
}
