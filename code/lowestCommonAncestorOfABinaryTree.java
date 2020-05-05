// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) -- recursion stack, worst case, unbalanced tree -- average case, balanced tree O(log n)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        
        return right;
    }
}
