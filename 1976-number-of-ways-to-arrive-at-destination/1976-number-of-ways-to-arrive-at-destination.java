class Solution {
    public class Pair {
        int node;
        String psf;
        int wsf;
        
        Pair(int node, String psf, int wsf) {
            this.node = node;
            this.psf = psf;
            this.wsf = wsf;
        }
    }
        
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            t1.add(v);
            t1.add(time);
            t2.add(u);
            t2.add(time);
            graph.get(u).add(t1);
            graph.get(v).add(t2);
        }

        int src = 0;

        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        int[] count = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(count, 0);
        dis[src] = 0;
        count[src] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wsf - b.wsf);
        pq.add(new Pair(src, "" + src, 0));

        while (pq.size() > 0) {
            Pair curr = pq.remove();

            if (vis[curr.node]) continue;
            vis[curr.node] = true;

            for (ArrayList<Integer> edge : graph.get(curr.node)) {
                int nbr = edge.get(0);
                int wt = edge.get(1);

                if (!vis[nbr]) {
                    if (curr.wsf + wt < dis[nbr]) {
                        dis[nbr] = curr.wsf + wt;
                        count[nbr] = count[curr.node];
                        pq.add(new Pair(nbr, curr.psf + nbr, curr.wsf + wt));
                    } else if (curr.wsf + wt == dis[nbr]) {
                        count[nbr] = (count[nbr] + count[curr.node]) % 1000000007;
                        pq.add(new Pair(nbr, curr.psf + nbr, curr.wsf + wt));
                    }
                }
            }
        }

        return count[n - 1];
    }
}
