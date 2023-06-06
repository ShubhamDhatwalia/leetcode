class MyQueue {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> supportStack = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        mainStack.push(x);
    }
    
    public int pop() {
        if(mainStack.size() ==0){
            return -1;
        }else{
            while(mainStack.size() != 1){
                int ele = mainStack.pop();
                supportStack.push(ele);
            }
            int remove = mainStack.pop();
            
            while(supportStack.size() >0){
                int ele = supportStack.pop();
                mainStack.push(ele);
            }
            return remove;
        }
    }
    
    public int peek() {
        if(mainStack.size() == 0){
            return -1;
        }else{
            while(mainStack.size() > 0){
                int ele = mainStack.pop();
                supportStack.push(ele);
            }
            int top = supportStack.peek();
            
            while(supportStack.size() > 0){
                int ele = supportStack.pop();
                mainStack.push(ele);
            }
            return top;
        }
    }
    
    public boolean empty() {
        return mainStack.size() ==0 && supportStack.size() ==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */