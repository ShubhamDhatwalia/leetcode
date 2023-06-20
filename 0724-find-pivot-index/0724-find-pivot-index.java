class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }
        int pref =0;
        for(int i=0; i< nums.length; i++){
           if(pref == totalSum - pref - nums[i]) return i;
            pref += nums[i];
        }
        return -1;
    }
}