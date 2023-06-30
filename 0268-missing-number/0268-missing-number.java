class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        for(int i=0; i<=nums.length; i++){
            if(!map.containsKey(i)) return i;
        }
        return -1;
    }
}