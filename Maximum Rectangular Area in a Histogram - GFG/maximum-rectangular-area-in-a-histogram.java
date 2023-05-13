//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    public static int[] n_s_l_i(long arr[], int n){
        int nsli[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
        while(st.size() >0 && arr[i] < arr[st.peek()]){
            int index = st.pop();
            nsli[index] = i;
        }
        st.push(i);
    }
    while(st.size() >0 ){
            int index = st.pop();
            nsli[index] = -1;
        }
        return nsli;
    }
    
    public static int[] n_s_r_i(long arr[], int n){
        int nsri[] = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(st.size() >0 && arr[i] < arr[st.peek()]){
                int index = st.pop();
                nsri[index] = i;
            }
            st.push(i);
        }
        while(st.size() >0 ){
                int index = st.pop();
                nsri[index] = n;
            }
            return nsri;
    }
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        int [] nsli = n_s_l_i( hist, (int) n);
        int [] nsri = n_s_r_i( hist, (int) n);
        
        long maxArea =0;
        
        for(int i=0; i<n; i++){
            long height = hist[i];
            int width = nsri[i]-nsli[i]-1;
            
            long area = height * width;
            
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
        
}



