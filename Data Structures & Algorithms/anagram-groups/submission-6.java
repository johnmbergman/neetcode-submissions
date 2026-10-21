class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (final String str : strs) {
            final Map<Character, Integer> key = buildKey(str);
            groups
                .computeIfAbsent(key, x -> new ArrayList<>())
                .add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private Map<Character, Integer> buildKey(final String s) {
        final Map<Character, Integer> key = new HashMap<>();
        for (final char ch : s.toCharArray()) {
            key.merge(ch, 1, Integer::sum);
        }
        return key;
    }
}
