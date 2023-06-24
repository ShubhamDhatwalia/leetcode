class Solution {
    public int eraseOverlapIntervals(int[][] A) {
        int n = A.length;
        
        Arrays.sort(A, (a,b)->{return a[0] - b[0];});
        
        int psp = Integer.MIN_VALUE;
        int pep = Integer.MIN_VALUE;
        int count =0;
        
        for(int[] interval : A){
            int csp = interval[0];
            int cep = interval[1];
            
            if(pep > csp){
                if(cep < pep){
                    pep = cep;
                    psp = csp;
                }
                
            }else{
                count++;
                psp = csp;
                pep = cep;
            }
            
        }
        return n-count;
    }
}