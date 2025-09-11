package Problems;

public class Q2785 {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder(s);
        int[] vowelsFreq = new int[10];
        int vowelsCount = 0;
        for(char c: s.toCharArray()) {
            int index = vowels.indexOf(c);
            if(index != -1) {
                vowelsFreq[index]++;
                vowelsCount++;
            }
        }
        int index = 0;
        while(vowelsCount > 0) {
            while(vowels.indexOf(s.charAt(index)) == -1) {
                index++;
            }
            int vowelIndex = 0;
            while(vowelsFreq[vowelIndex] == 0) {
                vowelIndex++;
            }
            sb.setCharAt(index, vowels.charAt(vowelIndex));
            vowelsFreq[vowelIndex]--;
            vowelsCount--;
            index++;
        }
        return sb.toString();
    }
}
