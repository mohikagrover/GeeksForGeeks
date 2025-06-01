class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int[] list1 = new int[n * n];
        int[] list2 = new int[n * n];
        int idx = 0;
        for (int[] row : mat1) {
            for (int val : row) {
                list1[idx++] = val;
            }
        }
        idx = 0;
        for (int[] row : mat2) {
            for (int val : row) {
                list2[idx++] = val;
            }
        }

        int i = 0;
        int j = list2.length - 1;
        int count = 0;

        while (i < list1.length && j >= 0) {
            int sum = list1[i] + list2[j];
            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}