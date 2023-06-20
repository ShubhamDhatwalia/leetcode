//   TC:  O(N)      SC: O(N)


// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int ans[] = new int[nums.length];
//         int pref [] = new int[nums.length];
//         pref[0] = 1;
        
//         for(int i=1; i< nums.length; i++){
//             pref[i] = pref[i-1] * nums[i-1];
//         }
//         int sufix[] = new int[nums.length];
//         sufix[nums.length-1] = 1;
//         for(int i=nums.length-2; i>=0; i--){
//             sufix[i] = sufix[i+1] * nums[i+1];
//         }
        
//         for(int i=0; i<nums.length; i++){
//             ans[i] = pref[i]*sufix[i];
//         }
//         return ans;
//     }
// }



//     TC: O(N)    SC:(1)

class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
        int ans[] = new int[nums.length];
        ans[0] = 1;
        
        for(int i=1; i< nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int sufix =1;
        for(int i=nums.length-1; i>=0; i--){
            ans[i] *= sufix;
            sufix *= nums[i];
        }
        return ans;
    }
}
