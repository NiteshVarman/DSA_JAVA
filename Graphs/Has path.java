import java.util.*;

public class graphs {
    static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 5));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) { // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                dfs(graph, e.dst, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dst, boolean[] vis) {
        if (src == dst) {
            return true;
        }
        vis[src] = true; // Corrected from '=='
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dst] && hasPath(graph, e.dst, dst, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        // Check if there's a path from node 0 to node 5
        boolean[] visited = new boolean[v];
        boolean pathExists = hasPath(graph, 0, 5, visited);
        System.out.println("\nPath exists from 0 to 5: " + pathExists);
    }
}
