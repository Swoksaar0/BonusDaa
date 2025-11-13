import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        System.out.println("=== MST Edge Removal and Replacement ===\n");

        List<Edge> mst = graph.kruskalMST();

        int totalWeight = 0;
        System.out.println("Original MST edges:");
        for (Edge e : mst) {
            System.out.println(e);
            totalWeight += e.weight;
        }
        System.out.println("Total MST weight: " + totalWeight);

        Edge toRemove = mst.get(2);
        System.out.println("\nRemoving edge: " + toRemove);

        List<Set<Integer>> components = graph.findComponents(mst, toRemove);
        System.out.println("\nComponents after removal:");
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i+1) + ": " + components.get(i));
        }

        Edge replacement = graph.findReplacementEdge(mst, toRemove, components);
        System.out.println("\nReplacement edge found: " + replacement);

        List<Edge> newMST = new ArrayList<>();
        for (Edge e : mst) {
            if (e != toRemove) {
                newMST.add(e);
            }
        }
        newMST.add(replacement);

        int newTotalWeight = 0;
        System.out.println("\nNew MST edges after replacement:");
        for (Edge e : newMST) {
            System.out.println(e);
            newTotalWeight += e.weight;
        }
        System.out.println("New MST total weight: " + newTotalWeight);
    }
}