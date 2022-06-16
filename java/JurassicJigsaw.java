import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class JurassicJigsaw {

    public static void main(String[] args) {

        // takes in inputs
        Scanner sc = new Scanner(System.in);
        String[] next = sc.nextLine().split(" ");
        int n = Integer.parseInt(next[0]);
        int k = Integer.parseInt(next[1]);
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        String[] chars = new String[n];
        for (int i = 0; i < n; i++) {
            chars[i] = sc.nextLine();
        }
        sc.close();

        // initialize the graph
        Graph g = new Graph();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                g.addEdge(new Edge(i, j, count(chars[i], chars[j], k)));
            }
        }

        // run kruskal's algorithm and print corresponding information
        Graph mst = kruskal(g, n);
        System.out.println(mst.sumWeights());
        System.out.println(mst.toString());
    }

    /**
     * count the number of different characters in two strings
     */
    private static int count(String a, String b, int len) {
        int j = 0;
        int ct = 0;
        while (j < len) {
            if (a.charAt(j) != b.charAt(j)) {
                ct++;
            }
            j++;
        }
        return ct;
    }

    private static Graph kruskal(Graph g, int n) {
        DSet sets = new DSet(n);
        Graph mst = new Graph();
        for (Edge e: g.sortedEdges()) {
            if (sets.find(e.src) != sets.find(e.dest)) {
                mst.addEdge(e);
                sets.union(e.src, e.dest);
            }
        }
        return mst;
    }


    private static class Edge {
        int src;
        int dest;
        Integer wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }


    private static class Graph {
        ArrayList<Edge> edges = new ArrayList<>();

        void addEdge(Edge e) {
            edges.add(e);
        }

        ArrayList<Edge> sortedEdges() {
            ArrayList<Edge> es = new ArrayList<>(edges);
            es.sort(Comparator.comparing(o -> o.wt));
            return es;
        }

        int sumWeights() {
            int sum = 0;
            for (Edge e: edges) {
                sum += e.wt;
            }
            return sum;
        }

        public String toString() {
            // print out src and dest of edges
            StringBuilder out = new StringBuilder();
            for (Edge e: edges) {
                out.append(e.src).append(" ").append(e.dest).append("\n");
            }
            return out.substring(0, out.length() - 1);
        }
    }


    private static class DSet {
        int[] parent, rank;

         DSet(int n) {
             parent = new int[n];
             rank = new int[n];
             for (int i = 0; i < n; i++) {
                 parent[i] = i;
             }
         }

         int find(int i) {
             if (parent[i] == i) {
                 return i;
             } else {
                 return find(parent[i]);
             }
         }

         int union(int i, int j) {
             // adapted from my own previous comp 251 assignment code
             int r1 = find(i);
             int r2 = find(j);

             if (rank[r1] < rank[r2]) {
                 parent[r1] = r2;
                 return r2;
             } else if (rank[r1] > rank[r2]) {
                 parent[r2] = r1;
                 return r1;
             } else {
                 parent[r1] = r2;
                 rank[r2]++;
                 return r2;
             }
         }
    }
}
