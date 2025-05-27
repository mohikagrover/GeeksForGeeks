class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> leaves = new ArrayList<>();
        if (preorder.length == 0) return leaves;
        
        if (preorder.length == 1) {
            leaves.add(preorder[0]);
            return leaves;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < preorder.length; i++) {
            int curr = preorder[i];
            
            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
            }
            
            boolean isLeaf = true;
            if (i + 1 < preorder.length && preorder[i + 1] < curr) {
                isLeaf = false;
            }
            
            if (i + 1 < preorder.length && preorder[i + 1] > curr) {
                if (stack.isEmpty() || preorder[i + 1] < stack.peek()) {
                    isLeaf = false;
                }
            }
            
            if (isLeaf) {
                leaves.add(curr);
            }
            
            stack.push(curr);
        }
        
        return leaves;
    }
}