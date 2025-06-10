/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        if(root==null){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (i == 0) {
                    ans.add(current.data);
                }

                if (current.right != null) queue.add(current.right );
                if (current.left != null) queue.add(current.left );
            }
        }

        return ans;
    }
}