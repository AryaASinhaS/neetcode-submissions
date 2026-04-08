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
    IP: Root node
    OP: RHS view
    Edge case: empty tree
    Approach:
    Find the level order taversal and fetch last values from each AL
    **/

    //fn to find level order traversal
    public List<Integer> levelOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> currentLevel = new ArrayList<>();

        if(root == null)
        {
            return new ArrayList<>();
        }

        currentLevel.add(root);

        while(!currentLevel.isEmpty())
        {
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            ArrayList<Integer> thisLevel = new ArrayList<>();

            for(TreeNode curr : currentLevel)
            {
                thisLevel.add(curr.val);
                if(curr.left != null)
                    nextLevel.add(curr.left);
                if(curr.right != null)
                    nextLevel.add(curr.right);
            }
            result.add(thisLevel.get(thisLevel.size()-1));
            currentLevel = nextLevel;
        }
        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        return levelOrderTraversal(root);
    }
}
