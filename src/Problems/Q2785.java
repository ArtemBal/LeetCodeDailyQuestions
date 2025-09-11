package Problems;

import java.util.PriorityQueue;

public class Q2785 {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        var pq = new PriorityQueue<Character>();
        for(char c: s.toCharArray()) {
            if(isVowel(c)) {
                pq.add(c);
            }
        }
        int index = 0;
        while(!pq.isEmpty()) {
            while(!isVowel(s.charAt(index))) {
                index++;
            }
            sb.setCharAt(index, pq.poll());
            index++;
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.indexOf(c) != -1;
    }

}
