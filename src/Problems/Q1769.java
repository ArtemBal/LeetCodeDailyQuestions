package Problems;

public class Q1769 {
    public int[] minOperations(String boxes) {
        char[] c = boxes.toCharArray();
        int n = c.length;
        int left = 0;
        int right = 0;
        int curr = 0;
        for(int i = n - 1; i > 0; i--) {
            if(c[i] == '1') {
                curr += i;
                right++;
            }
        }

        int[] ans = new int[n];
        ans[0] = curr;
        for(int i = 1; i < n; i++) {
            curr -= right;
            if(c[i] == '1') {
                right--;
            }
            if(c[i - 1] == '1') {
                left++;
            }
            curr += left;
            ans[i] = curr;
        }

        return ans;
    }
}
