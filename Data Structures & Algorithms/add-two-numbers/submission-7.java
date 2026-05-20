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

   public ListNode sumHead = null, curr = null;
   public int sum = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /**
        IP: head of 2 LLs
        OP: Head of new LL that represents the sum of both LLs
        Edge Case: Negative no.s//assumption: +ve no.s only, either LL is empty
        Approach:
        add the LLs and return head of new LL
        **/

        //edge cases
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return (l2);
        if(l2 == null)
            return (l1);
        
        ListNode list1 = l1, list2 = l2;

        while(list1 != null && list2 != null)
        {
            sum = sum + list1.val + list2.val;
            addNode(sum);
            list1 = list1.next;
            list2 = list2.next;
        }

        while(list1 != null)
        {
            sum = sum + list1.val;
            addNode(sum);
            list1 = list1.next;
        }

        while(list2 != null)
        {
            sum = sum + list2.val;
            addNode(sum);
            list2 = list2.next; 
        }

        if(sum != 0)
        {
            addNode(sum);
        }

        return sumHead;

    }

    //fn. to add node if sum < 10
    public void addNode(int s)
    {
        ListNode numNode = new ListNode(s%10);
        sum = s/10;
        if(sumHead == null)
        {
            curr = numNode;
            sumHead = curr;
        }
        else
        {
            curr.next = numNode;
            curr = curr.next;
        }
    }
}
