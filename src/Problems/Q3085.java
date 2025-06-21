package Problems;

public class Q3085 {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        int n = word.length();

        for (char c: word.toCharArray()) {
            freq[c - 'a']++;
        }
        int min = n;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0) continue;
            int freqEle = freq[i];
            int max = freqEle + k;
            int ans = 0;
            for(int j = 0; j < 26; j++){
                if(freq[j] < freqEle) {
                    ans = ans + freq[j];
                }
                else if(freq[j] > max) {
                    ans = ans + freq[j] - max;
                }
            }
            min = Math.min(min, ans);
        }
        return min;

    }
}
