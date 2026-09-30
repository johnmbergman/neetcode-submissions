class Solution {
    public int lengthOfLongestSubstring(String s) {
        final Set<Character> seen = new HashSet<>();
        int longest = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            final char ch = s.charAt(r);
            while (seen.contains(ch)) {
                final char lch = s.charAt(l);
                seen.remove(lch);
                l++;
            }
            seen.add(ch);
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
