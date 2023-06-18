class NumMatrix {
    
    private int pref[][];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        pref = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                int A = matrix[i][j];
                int B = j==0 ? 0 : pref[i][j-1];
                int C = i==0 ? 0 : pref[i-1][j];
                int D = i==0 || j==0 ? 0 : pref[i-1][j-1];
                
                pref[i][j] = A+B+C-D;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int A = pref[row2][col2];
        int B = col1==0 ? 0 : pref[row2][col1-1];
        int C = row1==0 ? 0 : pref[row1-1][col2];
        int D = row1==0 || col1==0 ? 0 : pref[row1-1][col1-1];
        
        return A-B-C+D;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */