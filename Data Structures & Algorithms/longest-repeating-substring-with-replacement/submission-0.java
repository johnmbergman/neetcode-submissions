class Solution {
    public int characterReplacement(final String s, final int k) {
        final Map<Character, Integer> count = new HashMap<>();
        int result = 0;
        int l = 0;
        int maxFrequency = 0;
        for (int r = 0; r < s.length(); r++) {
            final char ch = s.charAt(r);
            count.merge(ch, 1, Integer::sum);
            maxFrequency = Math.max(maxFrequency, count.get(ch));

            while ((r - l + 1) - maxFrequency > k) {
                final char lch = s.charAt(l);
                count.merge(lch, -1, Integer::sum);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }
        return result;
    }

    private int getMaxValue(final Map<Character, Integer> input) {
        int max = 0;
        for (int val : input.values()) {
            max = Math.max(max, val);
        }
        return max;
    }
}
