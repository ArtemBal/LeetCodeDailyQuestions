package Problems;

public class Q2211 {
    public int countCollisions(String directions) {
        int ans = 0;
        int movingRight = 0;
        char last = directions.charAt(0);
        for(char c: directions.toCharArray()) {
            if(c == 'R') {
                movingRight++;
                last = c;
            }
            if(c == 'S') {
                if(last == 'R') {
                    ans += movingRight;
                    movingRight = 0;
                }
                last = 'S';
            }
            if(c == 'L') {
                if(last == 'S') {
                    ans++;
                }
                if(last == 'R') {
                    ans += movingRight + 1;
                    movingRight = 0;
                    last = 'S';
                }
            }
        }
        return ans;
    }
}
