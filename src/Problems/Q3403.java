package Problems;

public class Q3403 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        int max = 0;
        String ans = "";
        for(int i = 0; i < n; i++) {
            max = Math.max(max, word.charAt(i));
        }

        for(int i = 0; i < n; i++) {
            if(word.charAt(i) == max) {
                int maxSubLen = Math.min(n - i, n - numFriends + 1);
                String currSub = word.substring(i, i + maxSubLen);
                if(ans.compareTo(currSub) < 0) {
                    ans = currSub;
                }
            }
        }
        return ans;
    }
}
