class Solution {
    public boolean isAnagram(final String s, final String t) {
        final Map<Character, Integer> a = getCounts(s);
        final Map<Character, Integer> b = getCounts(t);
        return a.equals(b);
    }

    private Map<Character, Integer> getCounts(final String s) {
        final Map<Character, Integer> result = new HashMap<>();
        for (char ch : s.toCharArray()) {
            result.merge(ch, 1, Integer::sum);
        }
        return result;
    }
}
