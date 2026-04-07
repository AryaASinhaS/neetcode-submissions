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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
        IP: head of LL , nth node to remove frm end
        OP: head of modified LL
        Edge Case: n is greater than length, empty list
        Approach:

        find length of LL
        n = len - n
        remove nth node from start
        **/

        

        //find the length of given LL
        int len = findLength(head);

        //find actual value of n from start
        n = len - n;

        //fn. to remove nth node from start
        head = removeNthNode(head, n);
        return head;

    }

    //fn. to find length of the LL
    public int findLength(ListNode head)
    {
        ListNode curr = head;
        int len = 0;

        if(head == null)
            return 0;

        while(curr != null)
        {
            len++;
            curr = curr.next;
        }

        return len;
    }

    //fn. to remove nth node from start
    public ListNode removeNthNode(ListNode head, int n)
    {
        if(n == 0)
        {
            head = head.next;
            return head;
        }

        ListNode curr = head, prev = null;
        int index = 0;

        while(index < n)
        {
            index++;
            prev = curr;
            curr = curr.next;
        }

        System.out.println(" prev = " + prev.val);
        System.out.println(" curr = " + curr.val);

        ListNode nxt = curr.next;
        prev.next = nxt;
        
        return head;
    }
}
