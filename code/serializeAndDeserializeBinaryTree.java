// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, "", "");
    }
    
    private String serialize(TreeNode root, String soFar, String tag) {
        if(root == null) {
            return soFar;
        }
        
        soFar += getDel(soFar) + root.val + "T" + tag;
        
        if(root.left == null && root.right == null) soFar += "TF";
        else if(root.right == null) soFar += "TN";
        
        if(root.left != null) soFar = serialize(root.left, soFar, "LC");
        if(root.right != null) soFar = serialize(root.right, soFar, "RC");
        
        return soFar;
    }
    
    private String getDel(String soFar) {
        return soFar.length() > 0 ? "," : "";
    }

    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] elements = data.split(",");
        
        Map<TreeNode, String> map = new HashMap<>();
        Stack<TreeNode> parents = new Stack<>();
        
        TreeNode root = new TreeNode(getValue(elements[0]));
        map.put(root, elements[0]);
        parents.push(root);
        for(int i=1; i<elements.length; i++) {
            String nodeStr = elements[i];
            int value = getValue(nodeStr);
            
            if(nodeStr.contains("LC")) {
                TreeNode leftNode = new TreeNode(value);
                parents.peek().left = leftNode;
                map.put(leftNode, nodeStr);
                
                if(map.get(parents.peek()).contains("N")) parents.pop();
                if(!nodeStr.contains("F")) parents.push(leftNode);
                
            } else if(nodeStr.contains("RC")) {
                TreeNode rightNode = new TreeNode(value);
                parents.peek().right = rightNode;
                map.put(rightNode, nodeStr);
                
                parents.pop();
                if(!nodeStr.contains("F")) parents.push(rightNode);
            }
        }
        
        return root;
    }
    
    
    private int getValue(String str) {
         return str.contains("T") ? 
                Integer.valueOf(str.substring(0, str.indexOf("T"))) :
                Integer.valueOf(str);
    }
    

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
