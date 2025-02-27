package Problems;

import java.util.HashSet;
import java.util.Set;

public class Q873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }
        int max = 0;
        for(int  i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int prev = arr[j];
                int curr = arr[i] + arr[j];
                int count = 2;
                while(set.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max < 3 ? 0 : max;
    }
}
