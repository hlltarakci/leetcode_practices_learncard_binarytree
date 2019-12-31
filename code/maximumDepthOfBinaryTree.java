// https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
		clarifying questions & edge cases:
		test: 
		
		algorithm: recursion
		
        n: node count
		time complexity: O(n)
		space complexity: O(n) -- recursion stack -- worst case might be a linked list 
	*/
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
