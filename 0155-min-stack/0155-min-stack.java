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



//  Approach 2:::   TC: O(1)  SC: O(2N)


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



//  Approach 3::   TC: O(1)  SC:O(N)


// class MinStack {

//     Stack<Integer> st = new Stack<>();
//     int minVal = Integer.MAX_VALUE;
    
//     public MinStack() {
        
//     }
    
//     public void push(int val) {
//         if(st.size() == 0){
//             st.push(val);
//             minVal = val;
//         }else{
//             if(val < minVal){
//                 int v = 2*val - minVal;
//                 st.push(v);
//                 minVal = val;
//             }else{
//                 st.push(val);
//             }
//         }
//     }
    
//     public void pop() {
//        if(st.isEmpty()){
//            return;
//        }
//        if(st.peek() < minVal){
//            int ans = minVal;
//            int prevMin = 2*minVal-st.pop();
//            minVal = prevMin;
//            ans = ans;
//        }else{
//            st.pop();
//        }
//     }
    
//     public int top() {
//         if(st.isEmpty()){
//             return -1;
//         }
//         if(st.peek() < minVal){
//             return minVal;
//         }else{
//             return st.peek();
//         }
//     }
    
//     public int getMin() {
//          if(st.isEmpty()){
//             return -1;
//         }
//         return minVal;
//     }
// }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

