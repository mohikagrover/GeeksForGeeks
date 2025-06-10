/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int maxDiameter =0;
    int diameter(Node root) {
        // Your code here
        height(root);
        return maxDiameter;
    }

    int height(Node node) {
        if (node == null) return -1; 

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int currentDiameter = leftHeight + rightHeight + 2;
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}