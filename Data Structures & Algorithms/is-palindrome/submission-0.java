class Solution {
    public boolean isPalindrome(final String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            final char leftChar = s.charAt(i);
            if (!Character.isLetterOrDigit(leftChar)) {
                i++;
                continue;
            }

            final char rightChar = s.charAt(j);
            if (!Character.isLetterOrDigit(rightChar)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
