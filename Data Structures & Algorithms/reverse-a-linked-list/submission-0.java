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
    public ListNode reverseList(ListNode head) {
        /**
        IP: Head of LL
        OP: Head of reversed LL
        Edge: Empty List
        Approach:

        Keep a next node ands prev node, use NN to have address of curr's NN and prev to swap the address
        return prev
        **/

        if(head == null)
            return null;

        ListNode curr = head.next, prev = head, nextNode = null;
        head.next = null;

        while( curr != null)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;

        
    }
}
