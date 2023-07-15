class Solution {
    public long gridGame(int[][] grid) {
        int n =2;
        int m = grid[0].length;
        long arr[][] = new long[n][m];
        arr[0][m-1] = grid[0][m-1];
        arr[1][0] = grid[1][0];
        for(int i=m-2; i>=0; i--){
            arr[0][i] = grid[0][i] + arr[0][i+1];
        }
        
        for(int i=1; i<m; i++){
            arr[1][i] = grid[1][i] + arr[1][i-1];
        }
        
        long ans = Long.MAX_VALUE;
        
        for(int i=0; i<m; i++){
            long option1 = i+1 == m ?0 : arr[0][i+1];
            long option2 = i-1 <0 ?0 : arr[1][i-1];
            
            long robot2Best = Math.max(option1, option2);
            ans = Math.min(ans, robot2Best);
        }
        return ans;
    }
}