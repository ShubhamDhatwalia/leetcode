class Solution {
    public long gridGame(int[][] grid) {
        int n =2;
        int m = grid[0].length;
        long sufix[] = new long[m];
         long pref[] = new long[m];
        
        for(int i=m-2; i>=0; i--){
            sufix[i] = grid[1][i] + sufix[i+1];
        }
        
        for(int i=1; i<m; i++){
            pref[i] = grid[0][i] + pref[i-1];
        }
        
        long ans = Math.min(pref[m-1],sufix[0]);
        
//         for(int i=0; i<m; i++){
//             long option1 = i+1 == m ?0 : sufix[i+1];
//             long option2 = i-1 <0 ?0 : pref[i-1];
            
//             long robot2Best = Math.max(option1, option2);
//             ans = Math.min(ans, robot2Best);
//         }
        for(int i=1;i<m-1;i++)
        {
            long curr=Math.max(pref[m-1]-pref[i],sufix[0]-sufix[i]);
            if(curr>0)
                    ans=Math.min(ans,curr);
            
        }
        return ans;
    }
}