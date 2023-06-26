class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
            int rem = (arr[i])%k;
            if(rem <0) rem = rem+k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        for(int rem : map.keySet()){
            if(rem ==0){
                if(map.containsKey(0) && map.get(0)%2 !=0) return false;
               continue;
            }
            
            int comprem = k-rem;
            
            if(map.containsKey(comprem) == false) {
                return false;
                
            }
            
            // if(map.get(rem) != map.get(comprem)) return false;    portal issue
            int a = map.get(rem);
            int b = map.get(comprem);
            if(a != b) return false;
        }
        return true;
    }
}