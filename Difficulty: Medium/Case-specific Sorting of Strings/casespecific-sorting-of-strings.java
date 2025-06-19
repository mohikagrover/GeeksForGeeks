class Solution {
    public static String caseSort(String s) {
        // code here
        int n = s.length();
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }

        Collections.sort(upper);
        Collections.sort(lower);
        StringBuilder result = new StringBuilder();
        int upperIndex = 0, lowerIndex = 0;

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(upper.get(upperIndex++));
            } else {
                result.append(lower.get(lowerIndex++));
            }
        }

        return result.toString();
    }
}