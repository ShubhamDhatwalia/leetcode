class MinStack {
    class Pair{
        int val;
        int min;
        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> st = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(new Pair(val, val));
        }else{
            int mymin = Math.min(val, st.peek().min);
            st.push(new Pair(val, mymin));
        }
    }
    
    public void pop() {
      
     
        st.pop();
      
    }
    
    public int top() {
        if(st.size() ==0){
            return -1;
        }
        return st.peek().val;
    }
    
    public int getMin() {
         if(st.size() ==0){
            return -1;
        }
       return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */