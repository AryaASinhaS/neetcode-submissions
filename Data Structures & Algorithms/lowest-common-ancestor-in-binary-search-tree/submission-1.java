/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
    IP: Root of a tree, two nodes
    OP: Node of the least common ancestor
    Edge Case: Empty Tree, Nodes not from the tree
    Approach:
    Find the path of both the nodes and store them in two different stacks
    Start comparing the stack contents as soon as content difers, return prev val
    **/

    //fn to find the path of a given node from root and store in stack and return it
    public Queue<TreeNode> pathP = new LinkedList<>();
    public TreeNode findPathNodeP(TreeNode root, TreeNode p)
    {
        System.out.println("out = " + root.val + " p = " + p.val);
        pathP.add(root);
        if(root.val == p.val)
        {
            return root;
        }

        if(root.val <= p.val)
        {
            return findPathNodeP(root.right, p);
        }
        else
        {
            return findPathNodeP(root.left, p);
        }
    }

    //fn to find the path of a given node from root and store in stack and return it
    public Queue<TreeNode> pathQ = new LinkedList<>();
    public TreeNode findPathNodeQ(TreeNode root, TreeNode q)
    {
        //System.out.println("out = " + root.val + " q = " + q.val);
        pathQ.add(root);
        if(root.val == q.val)
        {
            return root;
        }

        if(root.val <= q.val)
        {
            return findPathNodeQ(root.right, q);
        }
        else
        {
            return findPathNodeQ(root.left, q);
        }
    }

    //fn. to find lowest ancestor
    public TreeNode findLowestAncestor()
    {
        TreeNode commonAncestorP = new TreeNode(), 
                 commonAncestorQ = new TreeNode();
        System.out.println("Q1 = " + pathP.peek().val);
        while(pathP.size() > 0 && pathQ.size() > 0)
        {
            commonAncestorP = pathP.poll();
            commonAncestorQ = pathQ.poll();

            System.out.println("commonAncestorP = " + commonAncestorP.val);
            System.out.println("commonAncestorQ = " + commonAncestorQ.val);

            if(pathP.size() > 0 && pathQ.size() > 0
               && pathP.peek().val != pathQ.peek().val)
            {
                return commonAncestorP;
            }
        }

        //System.out.println("commonAncestorP = " + commonAncestorP);
        return commonAncestorP;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPathNodeP(root, p);
        findPathNodeQ(root, q);
        return findLowestAncestor();
    }
}
