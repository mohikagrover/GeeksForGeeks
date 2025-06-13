class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;
        int ans = -1;

        for (int pile : arr) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
        public boolean check(int[] piles, int h, int mid) {
        long hour = 0;
        for (int pile : piles) {
            hour += (pile + (long)mid - 1) / mid;
            if (hour > h) return false; // early termination
        }
        return hour <= h;
    }

}
