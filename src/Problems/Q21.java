package Problems;

import Problems.Entities.ListNode;

public class Q21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while(list1 != null && list2 != null) {
            if(list1.val >= list2.val) {
                curr.next = list2;
                list2 = list2.next;

            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 == null) ? list2 : list1;
        return head.next;
    }
}
