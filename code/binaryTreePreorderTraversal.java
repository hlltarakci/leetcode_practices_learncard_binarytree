// https://leetcode.com/problems/binary-tree-preorder-traversal/
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
            empty list case
		test: 
		
		algorithm:
            approach #1- recursion
            approach #2- iterative
		
        n: node count
		time complexity: O(n)
		space complexity: 
            O(n) -- recursion depth at worst case
            O(n) -- iterative approach, stack usage
	*/
    public List<Integer> preorderTraversal(TreeNode root) {
        // return preorderTraversalRecursive(root);
        return preorderTraversalIterative(root);
    }
    
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            resultList.add(current.val);
            
            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
        }
        
        return resultList;
    }
    
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        
        resultList.add(root.val);
        
        resultList.addAll(preorderTraversalRecursive(root.left));
        resultList.addAll(preorderTraversalRecursive(root.right));
        
        return resultList;
    }
    
}
