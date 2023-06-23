class Solution {
    class Pair{
        int node;
        int color;
        Pair(int node, int color){
            this.node = node;
            this.color = color;
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge : dislikes){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int vis[] = new int[n+1];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++){
            if(vis[i] != 0) continue;
            q.add(new Pair(i, 1));
                
                while(q.size() >0){
                    Pair curr = q.remove();
                    int node = curr.node;
                    int color = curr.color;
                    
                    vis[node] = color;
                    
                    int oppColor = color == 1? -1:1;
                    
                    for(int nbr : graph.get(node)){
                        
                        if(vis[nbr] == 0) q.add(new Pair(nbr, oppColor));
                        else if(vis[nbr] == oppColor) continue;
                        else if(vis[nbr] == color) return false;
                    }
                }
            }
        return true;
    }
}