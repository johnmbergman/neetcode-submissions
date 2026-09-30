class Solution {
    private static final Map<Character, Character> PARENS = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public boolean isValid(final String s) {
        final Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (PARENS.containsKey(ch)) {
                if (brackets.isEmpty()) return false;
                if (!brackets.pop().equals(PARENS.get(ch))) return false;
            } else {
                brackets.push(ch);
            }
        }

        return brackets.isEmpty();
    }
}
