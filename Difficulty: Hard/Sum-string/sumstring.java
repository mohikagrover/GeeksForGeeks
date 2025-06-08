class Solution {
    public boolean isSumString(String s) {
        // code here
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                String first = s.substring(0, i);
                String second = s.substring(i, i + j);

                if (isValid(first) && isValid(second)) {
                    if (checkSumString(first, second, s.substring(i + j))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean checkSumString(String first, String second, String rest) {
        String sum = addStrings(first, second);

        if (!rest.startsWith(sum)) return false;
        if (rest.equals(sum)) return true;

        return checkSumString(second, sum, rest.substring(sum.length()));
    }
    private boolean isValid(String str) {
        return !(str.length() > 1 && str.startsWith("0"));
    }
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}