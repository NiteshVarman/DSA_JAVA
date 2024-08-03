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

        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));

        graph[4].add(new edge(4, 3));
    }

    public static boolean cycle(ArrayList<edge>[] graph) {  //O(V+E)
        boolean vis[] = new boolean [graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(cycleutil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }



    public static boolean cycleutil(ArrayList<edge>[] graph, boolean vis[], int curr, int par) {   
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            
            if(!vis[e.dst] && cycleutil(graph, vis, e.dst, curr)) {
                return true;
            }
            else if(vis[e.dst] && e.dst != par) {
                return true;
            }

        }
        return false;
    }
                
    public static void main(String args[]) {
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        creategraph(graph);
        System.out.println(cycle(graph));
    }
}