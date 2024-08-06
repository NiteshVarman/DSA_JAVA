import java.util.*;

public class graphs {
    static class edge {
        int src;
        int dst;

        public edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void creategraph(ArrayList<edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new edge(2, 3));

        graph[3].add(new edge(3, 1));

        graph[4].add(new edge(4, 0));
        graph[4].add(new edge(4, 1));

        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));
    }

    public static void topsort(ArrayList<edge>[] graph) {   //O(V+E)
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topsortutil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.println(s.pop()+" ");
        }

    }

    public static void topsortutil(ArrayList<edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if(!vis[e.dst]) {
                topsortutil(graph, e.dst, vis, s);
            }
        }
        s.push(curr);
    }
                
    public static void main(String args[]) {
        int v = 6;
        ArrayList<edge>[] graph = new ArrayList[v];
        creategraph(graph);
        topsort(graph);
    }
}