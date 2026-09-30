class Solution {
    public String minWindow(final String s, final String t) {
        if (s == null) return "";
        if (t == null) return "";
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;

        String solution = "";
        int solutionLength = Integer.MAX_VALUE;
        int[] solutionIndices = { -1, -1 };

        final Map<Character, Integer> window = new HashMap<>();
        final Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.merge(c, 1, Integer::sum);
        }

        int have = 0;
        int need = counts.size();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            final char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (counts.containsKey(c)) {
                final int count = counts.get(c);
                if (count == window.get(c)) {
                    have++;
                }
            }

            while (have == need) {
                // smallest?
                final int currentLength = right - left + 1;
                if (currentLength < solutionLength) {
                    solutionLength = currentLength;
                    solutionIndices[0] = left;
                    solutionIndices[1] = right;
                }

                final char leftChar = s.charAt(left);
                window.merge(leftChar, -1, Integer::sum);
                if (counts.containsKey(leftChar) && window.get(leftChar) < counts.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        if (solutionLength == Integer.MAX_VALUE) return "";
        return s.substring(solutionIndices[0], solutionIndices[1] + 1);
    }
}
