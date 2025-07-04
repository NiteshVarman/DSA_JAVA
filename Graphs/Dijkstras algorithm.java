import java.util.*;

public class Graphs {
    static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dst = d;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll(); 
            int u = curr.n;

            if (vis[u]) {
                continue; 
            }
            vis[u] = true; 

            // neighbors
            for (int i = 0; i < graph[u].size(); i++) {
                Edge e = graph[u].get(i);
                int v = e.dst;
                int w = e.wt;

                
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w; 
                    pq.add(new Pair(v, dist[v])); 
                }
            }
        }


        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, src);
    }
}
