class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int ans =0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: arr){
            map.put(num, map.getOrDefault(num-diff, 0)+1);
            ans = Math.max(ans, map.get(num));
        }
        return ans;
    }
}