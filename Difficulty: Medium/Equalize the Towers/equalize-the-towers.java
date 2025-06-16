class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int low = Arrays.stream(heights).min().getAsInt();
        int high = Arrays.stream(heights).max().getAsInt();
        int answer = getTotalCost(heights, cost, low);

        while (low < high) {
            int mid = low + (high - low) / 2;
            int cost1 = getTotalCost(heights, cost, mid);
            int cost2 = getTotalCost(heights, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private int getTotalCost(int[] heights, int[] cost, int targetHeight) {
        int totalCost = 0;
        for (int i = 0; i < heights.length; i++) {
            totalCost += 1L * Math.abs(heights[i] - targetHeight) * cost[i];
        }
        return totalCost;
    }
}
