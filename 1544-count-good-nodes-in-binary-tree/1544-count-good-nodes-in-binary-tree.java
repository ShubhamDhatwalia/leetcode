/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   	int goodNode = 0;
    public int goodNodes(TreeNode root) {  
        searchGoodNodes(root, root.val);
        return goodNode;
    } 
    
    public void searchGoodNodes(TreeNode root, int max) {
        if(root == null) return;
        if(root.val >= max) {
			goodNode++;
            max = root.val;
        }
        searchGoodNodes(root.left, max);
        searchGoodNodes(root.right, max);
    }
}