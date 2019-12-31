// https://leetcode.com/problems/binary-tree-level-order-traversal/
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
            use a queue, do BFS
            null nodes in queue are delimiters for levels
		
        n: node count
		time complexity: O(n)
		space complexity: O(n) -- queue usage -- worst case might go up to n nodes
	*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                if(!result.isEmpty()) resultList.add(result);
                result = new ArrayList<>();
            } else {
                result.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(queue.peek() == null) queue.add(null);
            } 
        }
        
        return resultList;
    }
}
