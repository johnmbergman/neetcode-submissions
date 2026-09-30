class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int[] result = new int[nums.length];

        int leftProduct = 1;
        result[0] = leftProduct;
        for (int i = 1; i < nums.length; i++) {
            leftProduct *= nums[i-1];
            result[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
