package Problems;

import java.util.Arrays;

public class Q2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            long desiredPotionStrength = success / spells[i];
            if(success % spells[i] != 0) {
                desiredPotionStrength++;
            }
            int pos = search(desiredPotionStrength, potions);
            if(potions[pos] >= desiredPotionStrength) {
                ans[i] = potions.length - pos;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    private int search(long target, int[] potions) {
        int low = 0;
        int high = potions.length - 1;
        while(low < high) {
            int mid = (low + high) >> 1;
            if (potions[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
