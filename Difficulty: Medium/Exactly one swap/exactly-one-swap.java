class Solution {
    int countStrings(String s) {
        // code here
        int n = s.length();
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        long totalPossibleSwaps = (long) n * (n - 1) / 2;
        long sameCharSwapCount = 0;
        for (int count : charCounts) {
            sameCharSwapCount += (long) count * (count - 1) / 2;
        }
        long distinctSwaps = totalPossibleSwaps;
        distinctSwaps -= sameCharSwapCount;
        if (sameCharSwapCount > 0) {
            distinctSwaps += 1;
        }

        return (int) distinctSwaps;
    }
}