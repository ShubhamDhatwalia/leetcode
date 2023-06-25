class Solution {
    public int candy(int[] A) {
        int n= A.length;
        int l2r[] = new int[n];
        int r2l[] = new int[n];
        int total =0;
        
        for(int i=0; i<n; i++){
            if(i==0) l2r[i]=1;
            else{
                if(A[i-1] >= A[i])l2r[i] =1;
                else l2r[i] = l2r[i-1]+1;
            }
        }
        
        for(int i = n-1; i>=0; i--){
            if(i==n-1)r2l[i] =1;
            else{
                if(A[i+1] >= A[i]) r2l[i]=1;
                else r2l[i] = r2l[i+1] +1;
            }
        }
        
        for(int i=0; i<n; i++){
            total += Math.max(l2r[i], r2l[i]);
        }
        return total;
    }
}