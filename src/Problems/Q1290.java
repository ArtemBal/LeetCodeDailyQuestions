package Problems;

import Problems.Entities.ListNode;

public class Q1290 {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head != null) {
            result *= 2;
            if(head.val == 1) {
                result++;
            }
            head = head.next;
        }
        return result;
    }
}
