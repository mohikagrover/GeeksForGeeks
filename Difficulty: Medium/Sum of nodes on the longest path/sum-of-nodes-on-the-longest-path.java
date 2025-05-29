/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
        static class Result {
        int maxLength = 0;
        int maxSum = 0;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result result = new Result();
        findLongestPathSum(root, 0, 0, result);
        return result.maxSum;
    }

    private void findLongestPathSum(Node node, int currentLength, int currentSum, Result result) {
        if (node == null) return;

        currentSum += node.data;
        currentLength++;
        if (node.left == null && node.right == null) {
            if (currentLength > result.maxLength) {
                result.maxLength = currentLength;
                result.maxSum = currentSum;
            } else if (currentLength == result.maxLength) {
                result.maxSum = Math.max(result.maxSum, currentSum);
            }
            return;
        }

        findLongestPathSum(node.left, currentLength, currentSum, result);
        findLongestPathSum(node.right, currentLength, currentSum, result);
    }
}