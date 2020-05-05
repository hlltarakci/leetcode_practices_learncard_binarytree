// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(log n) -- queue usage -- worst case ?
    */
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            
            if(curr == null) {
                if(!queue.isEmpty()) queue.add(null);
                continue;
            }
            
            Node prev = queue.isEmpty() ? null : queue.peek();
            curr.next = prev;
            
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
        
        return root;
    }
}
