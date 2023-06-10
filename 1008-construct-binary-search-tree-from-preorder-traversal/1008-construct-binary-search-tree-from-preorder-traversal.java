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
    public  int indx =0;
    public TreeNode constructBST(int l, int r, int [] arr){
        if(indx == arr.length) return null;
        
        if(arr[indx] <l || arr[indx] >r){
            return null;
        }
        TreeNode node = new TreeNode(arr[indx]);
        indx++;
        node.left = constructBST(l, node.val, arr);
        node.right = constructBST(node.val, r, arr);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = constructBST(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
        indx =0;
        return root;
    }
}