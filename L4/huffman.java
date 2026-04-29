import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

class Huffman {

    // Comparator for Priority Queue
    static class MyComparator implements Comparator<Node> {
        public int compare(Node x, Node y) {
            return x.freq - y.freq;
        }
    }

    // Print Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] chars = {'P','Y','Q','L','M','F','O','R','S'};
        int[] freq = {10,4,22,19,6,8,31,40,30};

        int n = chars.length;

        PriorityQueue<Node> pq = new PriorityQueue<>(n, new MyComparator());

        // Create leaf nodes
        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        Node root = pq.peek();

        // Print codes
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}