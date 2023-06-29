class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int arr : nums){
            map.put(arr, map.getOrDefault(arr,0)+1);
        }
        
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) >1) {
                res.add(nums[i]);
                map.put(nums[i] , map.getOrDefault(nums[i],0)-1);
            }
            
        }
        return res;
    }
}