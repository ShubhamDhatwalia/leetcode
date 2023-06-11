class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int arr [] = new int[nums.length];
        int n = nums.length;
        Arrays.fill(arr ,-1);
        
        Stack<Integer> st = new Stack();
        for(int i=0; i<2*n-1; i++){
            while(st.size() >0 && nums[st.peek()] < nums[i%n]){
                arr[st.pop()] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return arr;
    }
}