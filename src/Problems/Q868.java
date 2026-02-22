package Problems;

public class Q868 {
    public int binaryGap(int n) {
        int ans = 0;
        while((n & 1) == 0 && n != 0) {
            n >>= 1;
        }
        int currPos = 0;
        int lastBit = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ans = Math.max(ans, currPos - lastBit);
                lastBit = currPos;
            }
            currPos++;
            n >>= 1;
        }
        return ans;
    }

}
