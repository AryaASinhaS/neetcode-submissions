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

        //find mid of LL
        ListNode slow = head, fast = head.next.next, midPrev = null;

        while(fast != null)
        {
            midPrev = slow;
            slow = slow.next;
            fast = (fast.next != null ? fast.next.next : null);
            System.out.println("loop1");
        }


        ListNode list2 = slow.next;
        slow.next = null;

        /**
         //list1
        System.out.println("list1");   
        ListNode curr1 = head;
        while(curr1 != null)
        {
            System.out.println(curr1.val);
            curr1 = curr1.next;   
        }
        //list2
        System.out.println("list2");   
        ListNode curr2 = list2;
        while(curr2 != null)
        {
            System.out.println(curr2.val); 
            curr2 = curr2.next;     
        }
        **/


        //reverse LL from mid till end
        ListNode curr = list2, prev = null;
       
        while (curr != null)
        {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;    
            System.out.println("loop2");   
        }

        list2 = prev;
        
        //list1
        System.out.println("list1");   
        ListNode curr1 = head;
        while(curr1 != null)
        {
            System.out.println(curr1.val);
            curr1 = curr1.next;   
        }
        //list2
        System.out.println("list2");   
        ListNode curr2 = list2;
        while(curr2 != null)
        {
            System.out.println(curr2.val); 
            curr2 = curr2.next;     
        }

        

        //merge from start and mid two at a time

         curr1 = head; curr2 = list2;
        while(curr1 != null && curr2 != null)
        {
            ListNode nextNode1 = curr1.next, nextNode2 = curr2.next;
            curr1.next = curr2;
            curr2.next = nextNode1;
            curr1 = nextNode1;
            curr2 = nextNode2;            
        }
    }
}
