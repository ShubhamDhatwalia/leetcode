class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        long sum =0;
        int n = arr.length;
        
        for(int i =0; i<n; i++){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                int r =i;
                int c = st.pop();
                int l = st.size()==0 ? -1: st.peek();
                
                long no_ = ((r-c)*(c-l))%mod;
                sum += (no_ * arr[c])%mod;
                sum %= mod;
            }
            st.push(i);
        }
        while(st.size() > 0){
                int r =n;
                int c = st.pop();
                int l = st.size()==0 ? -1: st.peek();
                
                long no_ = ((r-c)*(c-l))%mod;
                sum += (no_ * arr[c])%mod;
            sum %= mod;
            }
        return(int) sum%mod;
}
}