package Problems;

import java.util.Arrays;

public class Q3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int last = 0;
        int ans = 0;
        for(int[] arr: meetings) {
            int start = arr[0];
            int end = arr[1];
            if(start - 1 > last) {
                ans += start - last - 1;
            }
            last = Math.max(last, end);
        }
        return ans += days - last;
    }
}
