class Solution {
    class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c = c;
            this.freq =freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        
        StringBuilder res = new StringBuilder();
        
        Stack<Pair> st = new Stack<>();
        
        for(char c : s.toCharArray()){
           if(!st.isEmpty() && c == st.peek().c){
               st.peek().freq++;
           }else{
               st.add(new Pair(c, 1));
           }
            if(st.peek().freq == k){
                st.pop();
            }
        }
        while(!st.isEmpty()){
            Pair charWithFreq = st.pop();
            for(int i=0; i<charWithFreq.freq; i++){
               res.append(charWithFreq.c); 
            }
            
        }
        
        return res.reverse().toString();
    }
}