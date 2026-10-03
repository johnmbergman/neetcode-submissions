class Solution {
    private final Map<Character, String> T9 = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(final String digits) {
        final List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        search(0, digits, result, new StringBuilder());
        return result;
    }

    private void search(
        final int i,
        final String digits,
        final List<String> result,
        final StringBuilder sb
    ) {
        if (i == digits.length()) {
            result.add(sb.toString());
            return;
        }

        final Character digit = digits.charAt(i);
        final String possibleCharacters = T9.get(digit);
        for (final char ch : possibleCharacters.toCharArray()) {
            sb.append(ch);
            search(i+1, digits, result, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
