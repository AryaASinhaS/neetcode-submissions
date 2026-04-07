/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        /**
        IP: Head of LL
        OP: Boolean stating if there is a cycle or not
        Edge Case: Empty LL
        Approach:
        Use slow and fast pointer, increament fast by 2, slow by 1 if slow = fast return true else false
        **/

        if(head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next.next;

        while(slow != null && fast != null)
        {
            fast = (fast.next != null ? fast.next.next : null);

            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
