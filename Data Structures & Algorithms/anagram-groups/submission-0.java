class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> cache = new HashMap<>();

        for (String str : strs) {
            final Map<Character, Integer> k = getKey(str);
            if (!cache.containsKey(k)) cache.put(k, new ArrayList<>());
            cache.get(k).add(str);
        }

        return new ArrayList<>(cache.values());
    }

    private Map<Character, Integer> getKey(final String str) {
        final Map<Character, Integer> k = new HashMap<>();
        for (char ch : str.toCharArray()) {
            k.merge(ch, 1, Integer::sum);
        }
        return k;
    }
}
