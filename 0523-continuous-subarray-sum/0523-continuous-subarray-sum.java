class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum =0;
        
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            runningSum += nums[i];
            
            int rem = runningSum%k;
            if(map.containsKey(rem) == false)
                map.put(rem,i);
            else{
                int length = i-map.get(rem);
                if(length >1) return true;
            }
        }
        return false;
    }
}