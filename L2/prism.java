package L2;

import java.util.*;

public class Prims {

    static int V = 8; // A,B,C,D,E,F,G,H = 8 nodes

    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void primMST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;     // start from node A
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
            //A  B  C  D  E  F  G  H
            { 0, 5,12, 9, 0, 7, 0, 0}, // A
            { 5, 0, 6, 0,14, 0, 0, 8}, // B
            {12, 6, 0, 0, 0, 0, 0, 0}, // C
            { 9, 0, 0, 0, 0, 0, 0, 0}, // D
            { 0,14, 0, 0, 0, 0, 0, 3}, // E
            { 7, 0, 0, 0, 0, 0,15,10}, // F
            { 0, 0, 0, 0, 0,15, 0, 0}, // G
            { 0, 8, 0, 0, 3,10, 0, 0}  // H
        };

        Prims t = new Prims();
        t.primMST(graph);
    }
}