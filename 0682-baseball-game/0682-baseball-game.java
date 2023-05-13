class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        
       for(String op : ops){
           
           if(op.equals("C")){
               st.pop();
           }else if(op.equals("D")){
               st.push(2*st.peek());
           }else if(op.equals("+")){
               int p = st.pop();
               int sum = p+st.peek();
               st.push(p);
               st.push(sum);
           }else{
               st.push(Integer.valueOf(op));
           }
       }
        int sum=0;
        while(st.size() >0){
            sum += st.pop();
        }
        return sum;
    }
}