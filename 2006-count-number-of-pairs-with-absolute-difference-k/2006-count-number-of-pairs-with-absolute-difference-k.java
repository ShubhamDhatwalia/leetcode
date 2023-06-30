class Solution {
    public int countKDifference(int[] nums, int k) {
        
//         int count =0;
        
//         for(int i=0; i<nums.length; i++){
//             for(int j =i+1; j<nums.length; j++){
//                 if(Math.abs(nums[i]- nums[j]) == k) count++;
//             }
//         }
//         return count;
        
        int count =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
            count += map.getOrDefault(i-k,0) + map.getOrDefault(i+k, 0);
        }
        return count;
    }
}