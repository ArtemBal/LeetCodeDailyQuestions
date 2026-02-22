package Problems;

public class Q868 {
    public int binaryGap(int n) {
        String s = Integer.toUnsignedString(n, 2);
        int ans = 0;
        int lastBit = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                ans = Math.max(i - lastBit, ans);
                lastBit = i;
            }
        }
        return ans;
    }

}
