class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int result = 0;

        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            int volume = Math.min(leftHeight, rightHeight) * (right-left);
            result = Math.max(volume, result);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
