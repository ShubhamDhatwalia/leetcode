//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    public static int[] prevGreaterElementIndex(int []arr, int n){
        int pgei[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
        while(st.size() >0 && arr[i] > arr[st.peek()]){
            int index = st.pop();
            pgei[index] = i;
        }
        st.push(i);
    }
    while(st.size() >0 ){
            int index = st.pop();
            pgei[index] = -1;
        }
        return pgei;
    }
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int pgei[] = prevGreaterElementIndex(price, n);
        int span[] = new int[n];
        for(int i=0; i<n; i++){
            span[i] = i-pgei[i];
        }
        return span;
    }
}