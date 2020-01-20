// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
            first node of preorder gives root
            look for it in inorder to separate left and right subtrees
            then recurse based on indexes
		
        n: number of nodes
		time complexity: O(n)
		space complexity: O(n) -- recursion stack for worst case -- when tree not balanced
            when tree is guaranteed to be balanced this is O(log n)
        
	*/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length,
                    inorder, 0, inorder.length);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        // assuming array lengths for pre and in matches
        if(preStart == preEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = findIndex(inorder, root.val);
        
        root.left = build(preorder, preStart+1, preStart+1 + (rootIndex-inStart), 
                         inorder, inStart, rootIndex);
        
        root.right = build(preorder, preStart+1 + (rootIndex-inStart), preEnd,
                          inorder, rootIndex+1, inEnd);
        
        return root;
    }
    
    private int findIndex(int[] array, int val) {
        for(int i=0; i<array.length; i++) 
            if(array[i] == val) return i;
        return -1;
    }
    
}
