class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groupAnagrams = new HashMap<>();

        for (final String str : strs) {
            final Map<Character, Integer> key = getCounts(str);
            groupAnagrams.putIfAbsent(key, new ArrayList<>());
            groupAnagrams.get(key).add(str);
        }

        return new ArrayList<>(groupAnagrams.values());
    }

    private Map<Character, Integer> getCounts(final String s) {
        final Map<Character, Integer> result = new HashMap<>();
        for (final char ch : s.toCharArray()) {
            result.merge(ch, 1, Integer::sum);
        }
        return result;
    }
}
