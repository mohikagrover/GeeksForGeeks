class Solution {
    static class Ball {
        int color;
        int radius;

        Ball(int color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }
    public int findLength(int[] color, int[] radius) {
        // code here
        Stack<Ball> stack = new Stack<>();

        for (int i = 0; i < color.length; i++) {
            Ball current = new Ball(color[i], radius[i]);

            if (!stack.isEmpty()) {
                Ball top = stack.peek();
                if (top.color == current.color && top.radius == current.radius) {
                    stack.pop(); // Remove the matching pair
                    continue;
                }
            }
            stack.push(current);
        }

        return stack.size();
        
    }
}