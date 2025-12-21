package Problems;

public class Q955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        boolean[] sorted = new boolean[n];
        int ans = 0;
        for(int i = 0; i < len; i++) {
            boolean[] copy = sorted.clone();
            boolean deleted = false;
            for(int j = 1; j < n; j++) {
                if(sorted[j]) {
                    continue;
                }
                if(strs[j].charAt(i) > strs[j - 1].charAt(i)) {
                    copy[j] = true;
                }
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    deleted = true;
                    break;
                }
            }
            if(!deleted) {
                sorted = copy;
            }
        }
        return ans;
    }

}
