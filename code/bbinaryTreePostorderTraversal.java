// https://leetcode.com/problems/binary-tree-postorder-traversal/
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
		    approach #1: recursion
            approach #2: iterative
            
        n: node count
		time complexity: O(n)
		space complexity:
            O(n) -- recursion depth
            O(n) -- stack usage
	*/
    public List<Integer> postorderTraversal(TreeNode root) {
        // return postorderTraversalRecursive(root);
        return postorderTraversalIterative(root);
    }
    
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while(true) {
            // push all left
            if(current != null && !visited.contains(current)) {
                stack.push(current);
                current = current.left;
            }
            // at the end of left tree
            else {
                if(stack.isEmpty()) break;
                
                current = stack.peek();
                
                if(current.right == null || visited.contains(current.right)) {
                    stack.pop();
                    resultList.add(current.val);
                    visited.add(current);
                }
                
                current = current.right;
            }
        }
        
        return resultList;
    }
    
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        
        if(root == null) return resultList;
        
        resultList.addAll(postorderTraversalRecursive(root.left));
        resultList.addAll(postorderTraversalRecursive(root.right));
        resultList.add(root.val);
        
        return resultList;
    }
}
