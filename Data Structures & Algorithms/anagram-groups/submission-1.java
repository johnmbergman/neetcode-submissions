class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groupedAnagrams = new HashMap<>();
        for (String str : strs) {
            final Map<Character, Integer> k = buildKey(str);
            if (!groupedAnagrams.containsKey(k)) {
                groupedAnagrams.put(k, new ArrayList<>());
            }
            groupedAnagrams.get(k).add(str);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    private Map<Character, Integer> buildKey(final String str) {
        final Map<Character, Integer> k = new HashMap<>();
        for (char ch : str.toCharArray()) {
            k.merge(ch, 1, Integer::sum);
        }
        return k;
    }
}
