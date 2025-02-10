package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3164 {
    public String clearDigits(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
