class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int asteroid : asteroids){
            if(asteroid >0){
                st.push(asteroid);
            }
            else{
                while(st.size() >0 && st.peek() >0 && st.peek() < -asteroid){
                    st.pop();
                }
                if(st.size() >0 && st.peek() > -asteroid){
                    continue;
                }
                else if(st.size() >0 && st.peek() == -asteroid){
                    st.pop();
                }
                else{
                    st.push(asteroid);
                }
        }
       
    }
       int ans[] = new int[st.size()];
        for(int i= st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;                     
}
}