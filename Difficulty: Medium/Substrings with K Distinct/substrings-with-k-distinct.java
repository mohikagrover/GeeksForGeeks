class Solution {
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }
    
    private int countAtMostK(String s, int k) {
        if (k == 0) return 0;
        
        int[] freq = new int[26]; 
        int left = 0, right = 0;
        int distinctCount = 0;
        int result = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (freq[rightChar - 'a'] == 0) {
                distinctCount++;
            }
            freq[rightChar - 'a']++;
            
            while (distinctCount > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }
            
            result += right - left + 1;
            right++;
        }
        
        return result;
    }
}