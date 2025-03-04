package Problems;

import java.util.HashSet;
import java.util.Set;

public class Q1780 {
    public boolean checkPowersOfThree(int n) {
        int lastPower = -1;
        while(n > 0) {
            int currPower = 0;
            while(Math.pow(3, currPower) <= n) {
                currPower++;
            }
            currPower--;
            if(lastPower == currPower) {
                return false;
            }
            lastPower = currPower;
            n -= Math.pow(3, currPower);
            if(n == 0) {
                return true;
            }
        }
        return false;
    }
}
