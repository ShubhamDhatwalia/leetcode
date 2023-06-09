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
// Approach 1:


// class Solution {
//     class Pair{
//         boolean isBST;
//         long min;
//         long max;
        
//         Pair(boolean isBST, long min, long max){
//             this.isBST = isBST;
//             this.min = min;
//             this.max = max;
//         }
//     }
        
//         Pair dfs(TreeNode node){
//             if(node == null){
//                 return new Pair(true,Long.MAX_VALUE, Long.MIN_VALUE);
//             }
//             Pair left = dfs(node.left);
//             Pair right = dfs(node.right);
            
//             boolean amIBST = left.isBST && right.isBST && node.val > left.max && node.val < right.min;
            
//             if(amIBST == false){
//                 return new Pair(false, -1, -1);
//             }
            
//             long min = Math.min(node.val, left.min);
//             long max = Math.max(node.val, right.max);
//             return new Pair(true, min, max);
//         }
        
    
//     public boolean isValidBST(TreeNode root) {
//         Pair res = dfs(root);
//         return res.isBST;
//     }
// }


// Approach 2:::


class Solution {
    public boolean isValidBST(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        inOrder(root, ans);
        
        boolean valid = true;
        int prev = ans.get(0);
        
        for(int i=1; i< ans.size(); i++){
            if(ans.get(i) <= prev){
                valid = false;
            }
            prev = ans.get(i);
        }
        return valid;
    }
    public void inOrder(TreeNode node, ArrayList<Integer> ans){
        if(node == null) return;
        
        inOrder(node.left, ans);
        ans.add(node.val);
        inOrder(node.right, ans);
    }
}