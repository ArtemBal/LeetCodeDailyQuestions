package Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        var stack = new ArrayDeque<Integer>();
        stack.offer(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            int prev = stack.peekLast();
            int gcd = findGCD(prev, nums[i]);
            if(gcd > 1) {
                stack.removeLast();
                int newV = (int)(Math.abs(prev * 1L * nums[i]) / gcd * 1L);
                if(!stack.isEmpty() && findGCD(stack.peek(), newV) > 0) {
                    nums[i] = newV;
                    i--;
                } else {
                    stack.offer(newV);
                }
            } else {
                stack.offer(nums[i]);
            }
        }
        return new ArrayList<>(stack);
    }

    private static int findGCD(int a, int b) {
        if (b == 0) return a;
        else return findGCD(b, a % b);
    }
}
