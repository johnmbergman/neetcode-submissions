class Solution {
    public int trap(int[] height) {
        final int[] maxLeft = new int[height.length];
        final int[] maxRight = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        maxRight[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            volume += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }

        return volume;
    }
}
