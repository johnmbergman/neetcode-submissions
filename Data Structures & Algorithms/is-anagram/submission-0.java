class Solution {
    public boolean isAnagram(final String s, final String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        final Map<Character, Integer> cache = new HashMap<>();

        // Add characters from `s`
        for (char ch : s.toCharArray()) {
            cache.merge(ch, 1, Integer::sum);
        }

        // Remove characters from `t`
        for (char ch : t.toCharArray()) {
            cache.merge(ch, -1, Integer::sum);
        }

        // Verify result is map with values=0
        for (int count : cache.values()) {
            if (count != 0) return false;
        }

        return true;
    }
}
