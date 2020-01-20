// https://leetcode.com/problems/path-sum/
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
		
		algorithm:
            recursive: check children for sum - root value at leaf, if ever reach to 0, then done
		
        n: number of nodes
		time complexity: O(n)
		space complexity: O(n) -- recursion stack might go up to n, if tree not balanced
	*/
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum - root.val == 0 ) return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
