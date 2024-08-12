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

    public static void printpath(ArrayList<edge>[] graph, int src, int dst, String path) {  

        if(src == dst) {
            System.out.println(path + dst);
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            edge e = graph[src].get(i);
            printpath(graph, e.dst, dst, path+src);
        }

    }

                
    public static void main(String args[]) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];
        creategraph(graph);
        int src = 5;
        int dst = 1;
        printpath(graph, src, dst, "");
    }
}