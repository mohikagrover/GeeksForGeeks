class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int left = 1;
        int right = getMax(arr);
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (computeSum(arr, mid) <= k) {
                answer = mid; // possible answer, try smaller
                right = mid - 1;
            } else {
                left = mid + 1; // too big sum, try bigger divisor
            }
        }

        return answer;
    }

    private int computeSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.ceil((double) num / divisor);
        }
        return sum;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}