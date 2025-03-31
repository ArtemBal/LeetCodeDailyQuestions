package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String s) {
        int[][] segments = new int[26][2];
        for(int[] arr: segments) {
            Arrays.fill(arr, -1);
        }
        for(int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if(segments[curr][0] == -1) {
                segments[curr][0] = i;
            }
            segments[curr][1] = i + 1;
        }
        Arrays.sort(segments, (a, b) -> a[0] - b[0]);
        int last = -1;
        List<Integer> ans = new ArrayList<>();
        int lastStart = 0;
        for(int[] arr: segments) {
            int start = arr[0];
            int end = arr[1];
            if(last != -1 && start >= last) {
                ans.add(start - lastStart);
                lastStart = start;
            }
            if(last < end) {
                last = end;
            }
        }
        ans.add(s.length() - lastStart);
        return ans;
    }
}
