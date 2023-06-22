class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean path[] = new boolean[graph.length];
        int src = 0;
        int dest = graph.length-1;
        List<List<Integer>> bans = new ArrayList<>();
        List<Integer> sans = new ArrayList<>();
        dfs(graph, src, dest, path, sans, bans);
        return bans;
    }
    public void dfs(int[][] graph, int src, int dest, boolean[] path,List<Integer> sans,    List<List<Integer>> bans ){
        
        if(src == dest){
            sans.add(src);
            bans.add(new ArrayList<>(sans));
            sans.remove(sans.size() - 1);
            return;
        }
        path[src] = true;
        
        for(int nbr : graph[src]){
            if(path[nbr] == false){ 
                sans.add(src);
                dfs(graph, nbr, dest, path, sans, bans);
                sans.remove(sans.size() - 1);
            }
        }
        path[src] = false;
    }
}