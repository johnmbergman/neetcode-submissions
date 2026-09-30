class Solution {

    public int evalRPN(final String[] tokens) {
        if (tokens == null) return 0;

        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            // Check for number or operation
            final Optional<Integer> possibleInteger = tryParse(tokens[i]);
            if (possibleInteger.isPresent()) {
                // It's a number
                stack.push(possibleInteger.get());
            } else {
                // Perform operation
                final int right = stack.pop();
                final int left = stack.pop();
                final int result = performOperation(left, right, tokens[i]);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private Optional<Integer> tryParse(final String text) {
        try {
            return Optional.of(Integer.parseInt(text));
        } catch (final NumberFormatException ex) {
            return Optional.empty();
        }
    }

    private int performOperation(final int left, final int right, final String operation) {
        switch (operation) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
            default: throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
