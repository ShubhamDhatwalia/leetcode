class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0; 
        int high = nums.length-1;
        int ceil = nums.length;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                ceil = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ceil;
    }
}