class Solution {
    public boolean isPalindrome(final String s) {
        if (s == null) return false;
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            final char lch = s.charAt(l);
            final char rch = s.charAt(r);

            if (!Character.isLetterOrDigit(lch)) {
                l++;
            } else if (!Character.isLetterOrDigit(rch)) {
                r--;
            } else {
                if (Character.toLowerCase(lch) != Character.toLowerCase(rch)) {
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;
    }
}
