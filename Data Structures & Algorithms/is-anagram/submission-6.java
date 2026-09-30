class Solution {
    public boolean isAnagram(final String s, final String t) {
        // Assumption: 's' and 't' only consist of lowercase English letters
        // (no spaces, special characters, etc)

        final Map<Character, Integer> chars = new HashMap<>();
        for (final char ch : s.toCharArray()) {
            chars.merge(ch, 1, Integer::sum);
        }
        for (final char ch : t.toCharArray()) {
            chars.merge(ch, -1, Integer::sum);
        }

        for (final char ch : chars.keySet()) {
            if (chars.get(ch) != 0) return false;
        }

        return true;
    }
}
