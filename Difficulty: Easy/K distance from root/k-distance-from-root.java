/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> ans= new ArrayList<>();
        print(root,k,ans);
        
        return ans;
    }
        void print(Node node, int k, ArrayList<Integer> ans) {
            if (node == null) return ;
    
            if (k == 0) {
                ans.add(node.data);
                return ;
            }
    
            print(node.left, k - 1,ans);
            print(node.right, k - 1,ans);
    }
}