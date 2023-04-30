// Approach 1 ::   TC: O(N)  SC: O(N)


// class MinStack {
// Stack<Integer> mainStack;
//     public MinStack() {
//         mainStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         mainStack.push(val);
//     }
    
//     public void pop() {
//        mainStack.pop();
//     }
    
//     public int top() {
//         if(mainStack.size() == 0){
//             return -1;
//         }
//             return mainStack.peek();
//     }
    
//     public int getMin() {
//         if(mainStack.size() == 0){
//             return -1;
//         }
//         int minVal = Integer.MAX_VALUE;
//         Stack<Integer> temp = new Stack<>();
        
//         while(mainStack.size() != 0 ){
//             int val = mainStack.pop();
//             minVal = Math.min(val, minVal);
//             temp.push(val);
//         }
//         while(temp.size() != 0){
//             int val = temp.pop();
//             mainStack.push(val);
//         }
//         return minVal;
//     }
// }



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
            int minVal = Math.min(val, st.peek().min);
            st.push(new Pair(val, minVal));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
       return st.peek().val;
    }
    
    public int getMin() {
        if(st.size() == 0){
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