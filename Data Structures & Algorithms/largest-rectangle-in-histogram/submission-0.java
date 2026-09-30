class Solution {
    public int largestRectangleArea(int[] heights) {

        // Edge cases
        if (heights == null) throw new RuntimeException("Input cannot be null");
        final int n = heights.length;
        final Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                final int height = heights[stack.pop()];
                final int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
