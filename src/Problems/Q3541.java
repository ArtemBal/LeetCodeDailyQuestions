package Problems;

public class Q3541 {
    public int maxFreqSum(String s) {
        String vowels = "aeiou";
        int maxV = 0;
        int maxC = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int index = curr - 'a';
            freq[index]++;
            if(vowels.indexOf(curr) != -1) {
                maxV = Math.max(maxV, freq[index]);
            } else {
                maxC = Math.max(maxC, freq[index]);
            }
        }
        return maxV + maxC;
    }
}
