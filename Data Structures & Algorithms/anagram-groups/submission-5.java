class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (final String str : strs) {
            groups.merge(
                buildKey(str),
                new ArrayList<>(List.of(str)),
                (oldList, newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                });
        }

        return new ArrayList<>(groups.values());
    }

    private Map<Character, Integer> buildKey(final String str) {
        final Map<Character, Integer> k = new HashMap<>();
        for (final char ch : str.toCharArray()) {
            k.merge(ch, 1, Integer::sum);
        }
        return k;
    }
}
