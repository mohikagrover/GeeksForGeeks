class Solution {
      private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // backtrack
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    ArrayList<Integer> search(String pattern, String text) { 
        ArrayList<Integer> result = new ArrayList<>();
        if (pattern.isEmpty() || text.length() < pattern.length()) {
            return result;
        }

        int[] lps = buildLPS(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    result.add(i - j + 1); // 1-based indexing
                    j = lps[j - 1]; // continue search
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    
        // Code here
        
    }
}