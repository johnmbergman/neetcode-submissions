class Solution {
    public boolean isAnagram(final String s, final String t) {
        if (s == null && t != null) return false;
        if (t == null && s != null) return false;
        if (s.length() != t.length()) return false;

        final Map<Character, Integer> counts = new HashMap<>();
        for (final char ch : s.toCharArray()) {
            counts.merge(ch, 1, Integer::sum);
        }
        for (final char ch : t.toCharArray()) {
            counts.merge(ch, -1, Integer::sum);
        }

        for (final int val : counts.values()) {
            if (val != 0) return false;
        }

        return true;
    }
}
