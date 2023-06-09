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
    public TreeNode constructBST(int[] nums, int l, int r){
        if(l>r) return null;
        
        int mid = (l+r)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, l, mid-1);
        node.right = constructBST(nums, mid+1, r);
        
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int l =0;
        int r = nums.length -1;
        TreeNode root = constructBST(nums, l, r);
        return root;
    }
}