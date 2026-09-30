class Solution {
    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public boolean checkInclusion(final String s1, final String s2) {
        if (s1 == null) throw new RuntimeException("s1 cannot be null");
        if (s2 == null) throw new RuntimeException("s2 cannot be null");
        if (s1.length() > s2.length()) return false;

        // Build initial counts
        final Map<Character, Integer> s1Count = buildCharacterCountMap();
        final Map<Character, Integer> s2Count = buildCharacterCountMap();
        for (int i = 0; i < s1.length(); i++) {
            s1Count.merge(s1.charAt(i), 1, Integer::sum);
            s2Count.merge(s2.charAt(i), 1, Integer::sum);
        }

        // Calculate matches
        int matches = 0;
        for (char ch : CHARS) {
            if (s1Count.get(ch) == s2Count.get(ch)) matches++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == CHARS.length) return true;

            // Handle right (incoming) character
            final char rightChar = s2.charAt(right);
            s2Count.merge(rightChar, 1, Integer::sum);
            if (s2Count.get(rightChar) == s1Count.get(rightChar)) {
                matches++;
            } else if (s2Count.get(rightChar) == s1Count.get(rightChar) + 1) {
                matches--;
            }

            // Handle left (outgoing) character
            final char leftChar = s2.charAt(left);
            s2Count.merge(leftChar, -1, Integer::sum);
            if (s2Count.get(leftChar) == s1Count.get(leftChar)) {
                matches++;
            } else if (s2Count.get(leftChar) == s1Count.get(leftChar) - 1) {
                matches--;
            }

            left++;
        }

        return matches == CHARS.length;
    }

    private static Map<Character, Integer> buildCharacterCountMap() {
        final Map<Character, Integer> map = new HashMap<>();
        for (char ch : CHARS) {
            map.put(ch, 0);
        }
        return map;
    }
}
