package Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for(char c: chars) {
            if(c == '(' || c == '{' || c == '[') {
                dq.addFirst(c);
                continue;
            }
            Character temp = dq.poll();
            if(temp == null || (c == ')' && temp != '(') ||
                    (c == '}' && temp != '{') || (c == ']' && temp != '[')) {
                return false;
            }
        }
        return dq.isEmpty();
    }
}
