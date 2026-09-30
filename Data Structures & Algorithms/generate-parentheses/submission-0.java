class Solution {
    public List<String> generateParenthesis(final int n) {
        final List<String> result = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();
        generate(n, sb, result, 0, 0);
        return result;
    }

    private void generate(final int n,
                          final StringBuilder sb,
                          final List<String> result,
                          int open,
                          int closed) {
        // Base case
        if (closed == n) {
            result.add(sb.toString());
            return;
        }

        // Add open parentheses
        if (open < n) {
            sb.append("(");
            generate(n, sb, result, open + 1, closed);
            sb.setLength(sb.length() - 1);
        }

        // Add closed parentheses
        if (closed < open) {
            sb.append(")");
            generate(n, sb, result, open, closed + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
