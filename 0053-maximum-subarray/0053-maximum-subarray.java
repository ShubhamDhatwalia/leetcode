class Solution {
    public int maxSubArray(int[] nums) {
        
        int train =0;
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            int newTrain = nums[i];
            int prevTrain = train + newTrain;
        
            train = Math.max(newTrain, prevTrain);
            
            maxi = Math.max(train , maxi);
        }
        return maxi;
    }
}