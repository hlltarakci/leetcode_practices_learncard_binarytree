// https://leetcode.com/problems/symmetric-tree/
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
            empty tree -- symmetric
		test: 
		
		algorithm:
            approach #1 recursion:  
                null tree -- symmetric
                otherwise, check mirrorness of children
                if both child null -- symmetric
                if only one child null -- not symmetric
                if root val of children do not match -- not symmetric
                if children not symmetric -- not symmetric
            approach #2 iterative:
                keep two queues for left and right subtrees
                for nodes in opposite order (left for one, right for the other) 
                poll and compare 
		
        n: number of nodes
		time complexity: O(n)
		space complexity: O(n) -- recursion stack for approach 1, queue usage for approach 2
	*/
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirrorIterative(root.left, root.right);
    }
    
    private boolean isMirrorRecursive(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        
        return  t1.val == t2.val && 
                isMirrorRecursive(t1.left, t2.right) && 
                isMirrorRecursive(t1.right, t2.left);
    }
    
     private boolean isMirrorIterative(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);
         
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.remove();
            TreeNode node2 = queue2.remove();
            
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            
            queue1.add(node1.left);
            queue1.add(node1.right);
            
            queue2.add(node2.right);
            queue2.add(node2.left);
        }
        
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
