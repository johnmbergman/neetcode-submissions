class Solution {
    public boolean isAnagram(final String s, final String t) {
        if (s == null) return t == null;
        if (s.length() != t.length()) return false;

        // Approach 1: Sort
        // Runtime: O(s log s + t log t)
        // Space: O(1)

        // Approach 2: Map
        // Runtime: O(s + t)
        // Space: O(s + t)

        final Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.merge(ch, 1, Integer::sum);
        }
        for (char ch : t.toCharArray()) {
            charCount.merge(ch, -1, Integer::sum);
        }
        for (char k : charCount.keySet()) {
            if (charCount.get(k) != 0) return false;
        }
        return true;
    }
}
