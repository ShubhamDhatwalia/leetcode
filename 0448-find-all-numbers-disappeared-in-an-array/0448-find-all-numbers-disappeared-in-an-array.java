class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int arr : nums){
            set.add(arr);
        }
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
}