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

    Queue<TreeNode> pathP = new LinkedList<>();
    TreeNode lca = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        /**
        Edge case:
        either tree is null
        Nodes are part of different tree

        Approach:
        find path to reach node p and q from root and store them in different stacks
        compare the path, the 1st point of difference is the answer
        **/

        //create path from root to node p
        findPathFromGivenNode(root, p);
        computeLowestCommonAncestor(root, q);

        return lca;        
    }

    //code to create path from root to node p
    public void findPathFromGivenNode(TreeNode root, TreeNode p)
    {
        
        pathP.add(root);

        if(p.val == root.val)
        {
            return;
        }
        else if(p.val > root.val)
        {
            findPathFromGivenNode(root.right, p);
        }
        else
        {
            findPathFromGivenNode(root.left, p);
        }
    }

    //code to find mismatch while calculating path for q paralelly
    public void computeLowestCommonAncestor(TreeNode root, TreeNode q)
    {
        
        if(pathP.size() == 0 || root.val != pathP.peek().val)
        {
            return;
        }

        lca = pathP.poll();

        if(q.val == root.val)
        {
            return;
        }
        else if(q.val > root.val)
        {
            computeLowestCommonAncestor(root.right, q);
        }
        else
        {
            computeLowestCommonAncestor(root.left, q);
        }
    }
}
