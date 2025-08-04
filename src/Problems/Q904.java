package Problems;

import java.util.HashSet;
import java.util.Set;

public class Q904 {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int currFruits = 0;
        Set<Integer> currTypes = new HashSet<>();
        int l = 0, r = 0;
        while(r < fruits.length) {
            int currTree = fruits[r];
            if(currTypes.size() < 2) {
                currTypes.add(currTree);
            }
            if(currTypes.contains(currTree)) {
                currFruits++;
            } else {
                maxFruits = Math.max(maxFruits, currFruits);
                l = r - 1;
                currTypes.clear();
                currTypes.add(fruits[r]);
                currTypes.add(fruits[l]);
                while(fruits[l - 1] == fruits[r - 1]) {
                    l--;
                }
                currFruits = r - l + 1;
            }
            r++;
        }
        maxFruits = Math.max(maxFruits, currFruits);
        return maxFruits;
    }
}
