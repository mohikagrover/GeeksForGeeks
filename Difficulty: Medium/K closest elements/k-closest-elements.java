class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA == diffB) return b - a; // Prefer larger
            return diffA - diffB; // Prefer closer
        });

        for (int num : arr) {
            if (num != x) pq.offer(num); // Exclude x
        }

        int[] result = new int[k];
        int index = 0;

        while (k-- > 0 && !pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        return result;
    }
}
