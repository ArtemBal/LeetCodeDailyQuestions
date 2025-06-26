package Problems;

public class Q2311 {
    public int longestSubsequence(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int ans = 0;
        long currMult = 1;
        int currNum = 0;
        for(int i = n - 1; i >= 0; i--) {
            long curr = currNum + currMult * (c[i] - '0');
            if(curr <= k && ans < 32) {
                ans++;
                currMult *= 2;
                currNum = (int) curr;
            } else {
                while(i >= 0) {
                    if(c[i] == '0') {
                        ans++;
                    }
                    i--;
                }
                break;
            }
        }
        return ans;
    }
}
