package Problems;

public class Q3169 {
    public int countDays(int days, int[][] meetings) {
        int[] diff = new int[days + 2];
        for(int[] arr: meetings) {
            diff[arr[0]]++;
            diff[arr[1] + 1]--;
        }
        int count = 0;
        int ans = 0;

        for(int i = 1; i <= days; i++) {
            count += diff[i];
            if(count == 0) {
                ans++;
            }
        }
        return ans;
    }
}
