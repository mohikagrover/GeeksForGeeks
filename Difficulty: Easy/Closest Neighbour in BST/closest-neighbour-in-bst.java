/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        int floor = -1; // Use -1 or Integer.MIN_VALUE to indicate no valid floor found
        while (root != null) {
            if (root.data == k) {
                return k; // Exact match
            } else if (root.data < k) {
                floor = root.data; // Possible floor, move right to find a greater one <= k
                root = root.right;
            } else {
                root = root.left; // Value too big, move left
            }
        }
        return floor;
    }
}