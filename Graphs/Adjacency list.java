import java.util.*;

public class graphs {
    static class edge {
        int src;
        int dst;
        int wt;

        public edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }
    public static void main(String args[]) {
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];

        for(int i=0; i<v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 1, 5));

        graph[1].add(new edge(1, 2, 1));
        graph[1].add(new edge(1, 0, 5));
        graph[1].add(new edge(1, 1, 3));

        graph[2].add(new edge(2, 1, 1));
        graph[2].add(new edge(2, 3, 1));
        graph[2].add(new edge(2, 4, 4));

        graph[3].add(new edge(3, 1, 3));
        graph[3].add(new edge(3, 2, 1));

        graph[4].add(new edge(4, 2, 2));

        //2's neighbors
        for(int i=0; i<graph[2].size(); i++) {
            edge e = graph[2].get(i);
            System.out.println(e.dst);
        }
    }
}