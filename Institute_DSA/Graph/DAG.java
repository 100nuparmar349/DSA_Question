import java.util.*;

public class DAG {
    static class Edge {
        int src, dest;

        Edge(int src, int d) {
            this.src = src;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) dfs(graph, e.dest, vis, s);
        }
        s.push(curr);
    }

    public static void TopoSort(ArrayList<Edge> graph[], int v) {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, s);
            }
        }

        // Print the elements in topological order
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];

        // Initialize the graph with edges
        createGraph(graph, v);

        // Perform topological sort
        TopoSort(graph, v);
    }
}
