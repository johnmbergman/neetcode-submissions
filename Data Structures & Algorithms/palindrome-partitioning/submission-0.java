class Solution {
    public List<List<String>> partition(final String s) {
        final List<List<String>> result = new ArrayList<>();
        search(0, s, new ArrayList<String>(), result);
        return result;
    }

    private void search(
        final int i,
        final String s,
        final List<String> palindromes,
        final List<List<String>> result
    ) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(palindromes));
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                palindromes.add(s.substring(i, j + 1));
                search(j + 1, s, palindromes, result);
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }

    private boolean isPalindrome(final String s, final int left, final int right) {
        int i = left;
        int j = right;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
