package Problems;

import java.util.HashSet;
import java.util.Set;

public class Q1780 {
    public boolean checkPowersOfThree(int n) {
        Set<Integer> set = new HashSet<>();
        while(n > 0) {
            int currPower = 0;
            while(Math.pow(3, currPower) <= n) {
                currPower++;
            }
            currPower--;
            if(set.contains(currPower)) {
                return false;
            }
            set.add(currPower);
            n -= Math.pow(3, currPower);
            if(n == 0) {
                return true;
            }
        }
        return false;
    }
}
