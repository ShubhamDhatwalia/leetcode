class Solution {
    class Edge{
        int nbr;
        double wt;
        Edge(int nbr, double wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    class Pair{
        int node;
        double wsf;
        Pair(int node, double wsf){
            this.node = node;
            this.wsf = wsf;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            
            graph.get(u).add(new Edge(v, wt));
            graph.get(v).add(new Edge(u, wt));
        }
        
        boolean vis[] = new boolean[n];
        double dis[] = new double[n];
        Arrays.fill(dis,0.0);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return Double.compare(b.wsf,a.wsf);});
        
        pq.add(new Pair(start, 1));
        
        while(pq.size() >0){
            Pair curr = pq.remove();
            int node = curr.node;
            double wsf = curr.wsf;
            
            if(vis[node] ) continue;
            vis[node] = true;
            
            dis[node] = wsf;
            
            for(Edge e: graph.get(node)){
                int nbr = e.nbr;
                double wt = e.wt;
                
                if(!vis[nbr]) pq.add(new Pair(nbr, wsf*wt));
            }
        }
        return dis[end];
    }
}