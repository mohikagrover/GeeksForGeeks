class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, String s, List<String> current, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(end, s, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;

    }
}
