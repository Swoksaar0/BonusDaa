import java.util.*;

public class Graph {
    int vertices;
    List<Edge> edges;

    Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    List<Edge> kruskalMST() {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e);
            }
        }
        return mst;
    }

    List<Set<Integer>> findComponents(List<Edge> mstEdges, Edge removed) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new HashSet<>());
        }

        for (Edge e : mstEdges) {
            if (e == removed) continue;
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        boolean[] visited = new boolean[vertices];
        List<Set<Integer>> components = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                Set<Integer> component = new HashSet<>();
                dfs(i, adj, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void dfs(int node, List<Set<Integer>> adj, boolean[] visited, Set<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }

    Edge findReplacementEdge(List<Edge> mstEdges, Edge removed, List<Set<Integer>> components) {
        Edge best = null;

        for (Edge e : edges) {
            if (mstEdges.contains(e)) continue;

            boolean connects = false;
            for (int i = 0; i < components.size(); i++) {
                for (int j = i + 1; j < components.size(); j++) {
                    if ((components.get(i).contains(e.u) && components.get(j).contains(e.v)) ||
                            (components.get(i).contains(e.v) && components.get(j).contains(e.u))) {
                        connects = true;
                        break;
                    }
                }
                if (connects) break;
            }

            if (connects) {
                if (best == null || e.weight < best.weight) {
                    best = e;
                }
            }
        }
        return best;
    }
}