class Solution {
    public boolean isPalindrome(final String s) {
        if (s == null) return false;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            final char leftChar = s.charAt(l);
            final char rightChar = s.charAt(r);
            if (!isAlphanumeric(leftChar)) {
                l++;
            } else if (!isAlphanumeric(rightChar)) {
                r--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(final char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
