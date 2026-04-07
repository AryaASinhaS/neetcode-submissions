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

    ListNode mergedListHead = null, curr = mergedListHead;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /**
        IP: Head of two sorted LLs
        OP: Head of single merged sorted list
        Edge Case: Either or both list is empty
        Approach:
        Traverse both list and compare the smaller no
        whichever is smaller increase the pointer of that and insert it to the new list
        Whichever list is still remaining append it to end of the new single merged list
        **/

        ListNode curr1 = list1, curr2 = list2;

        while(curr1 != null && curr2 != null)
        {
            System.out.println("curr1 = " + curr1.val + " curr2 = " + curr2.val);
            if(curr1.val <= curr2.val)
            {
                insertionLinkedList(curr1.val);
                curr1= curr1.next;
            }
            else
            {
                insertionLinkedList(curr2.val);
                curr2= curr2.next;
            }
        }

        //inserting remaining nodes
        while(curr1 != null)
        {
            insertionLinkedList(curr1.val);
            curr1= curr1.next;
        }
        while(curr2 != null)
        {
            insertionLinkedList(curr2.val);
            curr2= curr2.next;
        }
        
        return mergedListHead;
        
    }

    //insertion to merged LL
    public void insertionLinkedList(int v)
    {
        ListNode mergedList = new ListNode(v,null);
        System.out.println(mergedList.val);

        if(mergedListHead == null)
        {
            mergedListHead = mergedList;
            mergedListHead.next = null;
            curr = mergedListHead;

        }
        else
        {
            curr.next = mergedList;
            curr = curr.next;
        }
    }
}