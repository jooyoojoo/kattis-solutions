import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DrivingRange {
    // This is adapted from my assignment solution for "Minimum Spanning Tree"
    // because they are essentially the same problem. Therefore, they can be solved using the same
    // approach.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] next = sc.nextLine().split(" ");
        int n = Integer.parseInt(next[0]);
        int m = Integer.parseInt(next[1]);

        if (n == 0 || n == 1 || m == 0) {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }

        // initialize the graph
        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            next = sc.nextLine().split(" ");
            g.addEdge(new Edge(Integer.parseInt(next[0]), Integer.parseInt(next[1]), Integer.parseInt(next[2])));
        }


        // run kruskal's algorithm and print corresponding information
        Graph mst = kruskal(g, n);
        if (mst.edges.size() != n - 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(mst.maxWeight());
        }
    }

    private static Graph kruskal(Graph g, int numNodes) {
        DSet sets = new DSet(numNodes);
        Graph mst = new Graph(numNodes);
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


    /**
     * A graph where the number of nodes is already known
     */
    private static class Graph {
        ArrayList<Edge> edges = new ArrayList<>();
        int numNodes;

        Graph(int numNodes) {
            this.numNodes = numNodes;
        }

        void addEdge(Edge e) {
            edges.add(e);
        }

        ArrayList<Edge> sortedEdges() {
            ArrayList<Edge> es = new ArrayList<>(edges);
            es.sort(Comparator.comparing(o -> o.wt));
            return es;
        }

        int maxWeight() {
            int max = 0;
            for (Edge e: edges) {
                max = Math.max(max, e.wt);
            }
            return max;
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

        void union(int i, int j) {
            // adapted from my own previous comp 251 assignment code
            int r1 = find(i);
            int r2 = find(j);

            if (rank[r1] < rank[r2]) {
                parent[r1] = r2;
            } else if (rank[r1] > rank[r2]) {
                parent[r2] = r1;
            } else {
                parent[r1] = r2;
                rank[r2]++;
            }
        }
    }
}
