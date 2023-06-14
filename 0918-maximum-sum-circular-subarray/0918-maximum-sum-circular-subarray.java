class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxtrain = 0;
        int maxi = Integer.MIN_VALUE;
        
        int mintrain =0;
        int mini = Integer.MAX_VALUE;
        
        int total =0;
        
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            
            maxtrain = Math.max(nums[i], maxtrain+nums[i]);
            maxi = Math.max(maxi, maxtrain);
            
            mintrain = Math.min(nums[i], mintrain+nums[i]);
            mini = Math.min(mini, mintrain);
            
        }
        if(total == mini) return maxi;
        return Math.max(maxi, total-mini);
    }
}