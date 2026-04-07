/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        /**
        IP: Head of the LL
        OP: Head of copied LL
        Edge Case: Empty LL
        Approach:

        Replicate the LL
        While replicating, create a hashmap to store original node as key 
        and duplicated node as value
        Iterate over original List again and assign random pointer this time. 
        **/

        HashMap<Node, Node> hm = new HashMap<>();

        //Replicate the original LinkedList
        Node newList = null, curr = head, newListCurr = null;

        while(curr != null)
        {
            Node n = new Node(curr.val);
            if(newList == null)
            {
                newList = n;
                newListCurr = newList;
            }
            else
            {
                newListCurr.next = n;
                newListCurr = newListCurr.next;   
            }

            hm.put(curr, newListCurr);
            curr = curr.next;
        }

        //assign random values for newList
        curr = head;
        newListCurr = newList;

        while(curr != null)
        {
            Node orgRandom = curr.random;
            Node newListRandom = hm.get(orgRandom);
            newListCurr.random = newListRandom;
            curr = curr.next;
            newListCurr = newListCurr.next;
        }
        return newList;
    }
}
