/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    static class Pair {
        Node node;
        int depth;

        Pair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        ArrayDeque<Pair> que = new ArrayDeque<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        que.add(new Pair(root, 0));

        while (que.size() > 0) {
            Pair rem = que.remove();
            left = Math.min(left, rem.depth);
            right = Math.max(right, rem.depth);
            if (!map.containsKey(rem.depth)) {
                map.put(rem.depth, rem.node.data);
            }

            if (rem.node.left != null) {
                que.add(new Pair(rem.node.left, rem.depth - 1));
            }

            if (rem.node.right != null) {
                que.add(new Pair(rem.node.right, rem.depth + 1));
            }
        }

        for (int i = left; i <= right; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
