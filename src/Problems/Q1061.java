package Problems;

import java.util.Arrays;

public class Q1061 {
    int[] arr;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        arr = new int[26];
        Arrays.setAll(arr, i -> i);
        for(int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';

            int p1 = find(c1);
            int p2 = find(c2);
            if(p1 < p2) {
                arr[p2] = p1;
            } else {
                arr[p1] = p2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: baseStr.toCharArray()) {
            int curr = find(ch - 'a');
            sb.append((char) (curr + 'a'));
        }
        return sb.toString();
    }

    private int find(int x) {
        if(arr[x] != x) {
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }
}
