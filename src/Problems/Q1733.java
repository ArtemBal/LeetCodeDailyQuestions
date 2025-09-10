package Problems;

import java.util.Arrays;
import java.util.HashSet;

public class Q1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] allUsers = new boolean[m + 1][n + 1];

        for(int i = 0; i < languages.length; i++) {
            for(int j = 0; j < languages[i].length; j++) {
                int curr = languages[i][j];
                allUsers[i][curr] = true;
            }
        }
        var problemUsers = new HashSet<Integer>();
        int[] noLangFriendsFreq = new int[n + 1];
        for(int[] a: friendships) {
            int first = a[0] - 1;
            int second = a[1] - 1;
            boolean flag = false;
            for(int i = 0; i < n + 1; i++) {
                if(allUsers[first][i] && allUsers[second][i]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                if(problemUsers.add(first)) {
                    for(int f: languages[first]) {
                        noLangFriendsFreq[f]++;
                    }
                }

                if(problemUsers.add(second)) {
                    for(int s: languages[second]) {
                        noLangFriendsFreq[s]++;
                    }
                }
            }
        }
        return problemUsers.size() - Arrays.stream(noLangFriendsFreq).max().getAsInt();
    }
}
