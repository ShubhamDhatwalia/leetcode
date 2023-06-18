class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int pref[] = new int[1001];
        
        for(int trip[] : trips){
            int numOfPass = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            pref[from] += numOfPass;
            pref[to] -= numOfPass;
        }
        for(int i=1; i<1001; i++){
            pref[i] = pref[i]+pref[i-1];
        }
        for(int i=0; i<1001; i++){
            if(pref[i] > capacity) return false;
        }
        return true;
    }
}