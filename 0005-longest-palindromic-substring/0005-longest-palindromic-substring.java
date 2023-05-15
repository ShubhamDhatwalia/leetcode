// Approach 1   TC:: O(N^3)

// class Solution {
//     public String longestPalindrome(String s) {
//         if(isPalindrome(s)) return s;
        
//         for(int i = s.length()-1; i>=0; i-- ){
//             for(int j=0; i+j<=s.length(); j++){
//                 if(isPalindrome(s.substring(j , i+j))){
//                     return s.substring(j, i+j);
//                 }
//             }
//         }
//         return "";
//     }
//     public boolean isPalindrome(String s){
//         int l=0;
//         int r= s.length()-1;
//         while(l<=r && s.charAt(l) == s.charAt(r)){
//             l++;
//             r--;
//         }
//         return l>=r;
//     }
// }

// Approach 2          TC:: O(N^2)

class Solution {
    public String longestPalindrome(String s) {
        String lps ="";
        
        for(int i=0; i<s.length(); i++){
            String odd = expandPalindrome(s , i, i);
            String even = expandPalindrome(s, i, i+1);
            
            if(lps.length() < odd.length()){
                lps = odd;
            }
            if(lps.length() < even.length()){
                lps = even;
            }
        }
        return lps;
    }
    public String expandPalindrome(String s, int l, int r){
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}