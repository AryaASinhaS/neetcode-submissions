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
    public void reorderList(ListNode head) {

        /**
        IP: Head of LL
        OP: N/A
        Edge Case: Empty, size 1 LL
        Approach:

        Break from mid, reverse LL from mid till end
        merge start to mid and reversed LL each element at a time
        **/

        if(head == null || head.next == null)
        {
            return;
        }

        ListNode list1 = head;
        //find and break from mid
        ListNode list2 = breakFromMid(head);

        //reverse the second part
        list2 = reverseList(list2);

        //merge list1 and list2
        mergeLists(list1, list2);

    }

    //fn to reverse LL and return head of reversedList
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
            return head;
        
        ListNode prev = null, curr = head;

        while(curr != null)
        {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    //fn. to find break from mid and retun head of mid till end part
    public ListNode breakFromMid(ListNode head)
    {
        if(head == null)
            return head;
        
        //code to find mid
        ListNode slow = head, fast = head.next.next, secondList = null;

        while(fast !=  null)
        {
            slow = slow.next;
            fast = (fast.next != null ? fast.next.next : null);
        }

        secondList = slow.next;
        slow.next = null;
        return secondList;
    }

    //fn. to merge two lists and return head of 1st/merged list
    public void mergeLists(ListNode head1, ListNode head2)
    {
        
        ListNode curr1 = head1, curr2 = head2;

        while(curr1 != null && curr2 != null)
        {
            ListNode nextNode1 = curr1.next;
            ListNode nextNode2 = curr2.next;
            curr1.next = curr2;
            curr2.next = nextNode1;
            curr1 = nextNode1;
            curr2 = nextNode2;
        }

    }
}
