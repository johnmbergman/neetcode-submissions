class Solution {
    public String minWindow(final String s, final String t) {
        if (s == null) return "";
        if (t == null) return "";
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        String solution = "";
        int minLength = Integer.MAX_VALUE;

        final Map<Character, Integer> tCharCount = calculateCharCount(t);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                final String substring = s.substring(i, j);
                final Map<Character, Integer> sCharCount = calculateCharCount(substring);
                if (containsAtLeast(sCharCount, tCharCount)) {
                    if (substring.length() < minLength) {
                        solution = substring;
                        minLength = solution.length();
                    }
                }
            }
        }

        return solution;

    }

    private boolean containsAtLeast(
        final Map<Character, Integer> left,
        final Map<Character, Integer> right
    ) {
        for (char k : right.keySet()) {
            final int leftCount = left.getOrDefault(k, 0);
            final int rightCount = right.get(k);
            if (leftCount < rightCount) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> calculateCharCount(final String str) {
        final Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counts.merge(ch, 1, Integer::sum);
        }
        return counts;
    }
}
