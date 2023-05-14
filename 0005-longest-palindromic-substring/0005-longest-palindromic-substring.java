class Solution {
    public String longestPalindrome(String s) {
        if(isPalindrome(s)) return s;
        
        for(int i = s.length()-1; i>=0; i-- ){
            for(int j=0; i+j<=s.length(); j++){
                if(isPalindrome(s.substring(j , i+j))){
                    return s.substring(j, i+j);
                }
            }
        }
        return "";
    }
    public boolean isPalindrome(String s){
        int l=0;
        int r= s.length()-1;
        while(l<=r && s.charAt(l) == s.charAt(r)){
            l++;
            r--;
        }
        return l>=r;
    }
}