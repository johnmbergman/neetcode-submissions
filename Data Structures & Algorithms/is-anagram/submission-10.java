class Solution {
    public boolean isAnagram(final String s, final String t) {
        final int[] counts = new int[26];
        for (final char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (final char ch : t.toCharArray()){
            counts[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) return false;
        }
        return true;
    }
}
