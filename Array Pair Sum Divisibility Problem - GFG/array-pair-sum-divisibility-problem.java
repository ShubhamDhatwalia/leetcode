//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] arr, int k) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
            int rem = (arr[i])%k;
            if(rem <0) rem = rem+k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        for(int rem : map.keySet()){
            if(rem ==0){
                if(map.containsKey(0) && map.get(0)%2 !=0) return false;
               continue;
            }
            
            int comprem = k-rem;
            
            if(map.containsKey(comprem) == false) {
                return false;
                
            }
            
            if(map.get(rem) != map.get(comprem)) return false;
            // int a = map.get(rem);
            // int b = map.get(comprem);
            // if(a != b) return false;
        }
        return true;
    }
}