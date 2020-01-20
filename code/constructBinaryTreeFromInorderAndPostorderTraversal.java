// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
            last element of postorder = root
            locate root in inorder - left is left subtree, right is right subtree
            recursively give subtrees
		
    n: number of nodes
		time complexity: O(n) 
		space complexity: O(n) -- recursion stack when tree is not balanced
	*/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecursive(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    private TreeNode buildTreeRecursive(int[] inorder, int startInOrder, int endInOrder, 
                                       int[] postorder, int startPostOrder, int endPostOrder)  {
        
        if(endInOrder == startInOrder || endPostOrder == startPostOrder ) return null;

        TreeNode root = new TreeNode(postorder[endPostOrder -1]);
        int rootAtInOrder = findIndexOfElement(inorder, root.val);
        
        root.left = buildTreeRecursive(inorder, startInOrder, rootAtInOrder, 
                        postorder, startPostOrder, startPostOrder + (rootAtInOrder-startInOrder));
        root.right = buildTreeRecursive(inorder, rootAtInOrder + 1, endInOrder,
                        postorder, startPostOrder + (rootAtInOrder-startInOrder), endPostOrder-1 );
        
        return root;
        
    }
    
    private int findIndexOfElement(int[] array, int element) {
        for(int i=0; i < array.length; i++) 
            if(array[i] == element) return i;
        return -1;
    }
}
