// https://leetcode.com/problems/binary-tree-inorder-traversal/
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
            approach #1: recursice
            approach #2: iterative
		
		time complexity: O(n)
		space complexity: 
            O(n) -- recursion depth at worst case
            O(n) -- iterative case uses stack
	*/
    public List<Integer> inorderTraversal(TreeNode root) {
        // return inorderTraversalRecursive(root);
        return inorderTraversalIterative(root);
    }
    
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        Stack<TreeNode> stack = new Stack<>();
    
        while(true) {
            // put all lefts to stack
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            // all lefts in stack already, print them
            else {
                if(stack.isEmpty()) break;
                
                TreeNode node = stack.pop();
                resultList.add(node.val);
                if(node.right != null) stack.push(node.right);
            }
        }
        
        return resultList;
    }
    
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        
        resultList.addAll(inorderTraversalRecursive(root.left));
        resultList.add(root.val);
        resultList.addAll(inorderTraversalRecursive(root.right));
        
        return resultList;
    }
}
