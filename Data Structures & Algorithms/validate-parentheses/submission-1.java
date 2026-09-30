class Solution {
    private static final Map<Character, Character> DELIMETERS = new HashMap<>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(final String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (final char ch : s.toCharArray()) {

            // Check for closing parens
            if (DELIMETERS.containsKey(ch)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != DELIMETERS.get(ch)) return false;
            } else {
                // Assumption: only contains parentheses
                // Handle opening parens
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
