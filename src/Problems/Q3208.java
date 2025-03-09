package Problems;

public class Q3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n + n];
        System.arraycopy(colors, 0, arr, 0, n);
        System.arraycopy(colors, 0, arr, n, n);

        int count = 0;
        int curr = 1;
        for(int i = 1; i < n + k - 1; i++) {
            if(arr[i] != arr[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }
            if(curr >= k) {
                count++;
            }
        }
        return count;
    }

}
