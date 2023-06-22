//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, boolean[] path, int node){
        vis[node] = true;
        path[node] = true;
        
        for(int nbr : graph.get(node)){
            if(vis[nbr] == false){
                boolean isCycle = dfs(graph, vis, path, nbr);
                if(isCycle) return true;
            }
            else if(vis[nbr] && path[nbr]) return true;
        }
        path[node] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        // code here
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]) continue;
            boolean isCycleComp = dfs(graph, vis, path, i);
            if(isCycleComp) return true;
        }
        return false;
    }
}