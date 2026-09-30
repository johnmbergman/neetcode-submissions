class Solution {
    public boolean isAnagram(final String s, final String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        final int[] counts = new int[26];
        for (char ch : s.toCharArray()) counts[ch-'a']++;
        for (char ch : t.toCharArray()) counts[ch-'a']--;

        for (int i : counts) {
            if (i != 0) return false;
        }
        return true;
    }
}
