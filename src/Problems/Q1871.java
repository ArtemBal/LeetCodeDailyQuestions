package Problems;

public class Q1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int lastJ = 0;
        for(int i = 0; i < n; i++) {
            if(reachable[i]) {
                for(int j = Math.max(i + minJump, lastJ); j <= i + maxJump && j < n; j++) {
                    if(s.charAt(j) == '0') {
                        reachable[j] = true;
                    }
                }
                lastJ = i + maxJump;
            }
        }
        return reachable[n - 1];
    }
}
