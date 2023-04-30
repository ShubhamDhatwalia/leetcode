class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ')'){
                st.push(ch);
                continue;
            }
            String popped = "";
            while(st.size() >0 && st.peek() != '('){
                popped += st.pop();
            }
            if(st.size() > 0){
                st.pop();
            }
            if(popped.length() > 0){
                for(char c : popped.toCharArray()){
                    st.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() >0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}