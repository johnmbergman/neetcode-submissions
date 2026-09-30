class Solution {
    public int lengthOfLongestSubstring(final String s) {
        int longest = 0;
        final Set<Character> distinct = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            final char ch = s.charAt(r);
            while (distinct.contains(ch)) {
                distinct.remove(s.charAt(l));
                l++;
            }
            distinct.add(ch);
            longest = Math.max(distinct.size(), longest);
        }

        return longest;
    }
}
