package L2;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Kruskal {

    int V = 8, E = 10;

    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST(Edge edges[]) {
        Arrays.sort(edges);

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        System.out.println("Edge \tWeight");

        int count = 0, i = 0;

        while (count < V - 1) {
            Edge next = edges[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {
                System.out.println(next.src + " - " + next.dest + "\t" + next.weight);
                union(parent, x, y);
                count++;
            }
        }
    }

    public static void main(String[] args) {

        Edge edges[] = new Edge[10];

        for (int i = 0; i < 10; i++)
            edges[i] = new Edge();

        // A=0, B=1, C=2, D=3, E=4, F=5, G=6, H=7

        edges[0].src=0; edges[0].dest=1; edges[0].weight=5;
        edges[1].src=1; edges[1].dest=2; edges[1].weight=6;
        edges[2].src=0; edges[2].dest=2; edges[2].weight=12;
        edges[3].src=0; edges[3].dest=3; edges[3].weight=9;
        edges[4].src=1; edges[4].dest=4; edges[4].weight=14;
        edges[5].src=4; edges[5].dest=7; edges[5].weight=3;
        edges[6].src=7; edges[6].dest=1; edges[6].weight=8;
        edges[7].src=5; edges[7].dest=7; edges[7].weight=10;
        edges[8].src=0; edges[8].dest=5; edges[8].weight=7;
        edges[9].src=5; edges[9].dest=6; edges[9].weight=15;

        Kruskal k = new Kruskal();
        k.kruskalMST(edges);
    }
}

fewfhrporssbsgsr