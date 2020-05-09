// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/538/

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
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        countUnivalSubtreesRec(root);
        return count;
    }
    
    public boolean countUnivalSubtreesRec(TreeNode root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            count++;
            return true;
        };
        
        boolean left = countUnivalSubtreesRec(root.left);
        boolean right = countUnivalSubtreesRec(root.right);
        
        if( (root.left == null || (left && root.left.val == root.val)) &&
            (root.right == null || (right && root.right.val == root.val)) ) {
            count++;
            return true;
        }
        
        return false;
    }
    
}

