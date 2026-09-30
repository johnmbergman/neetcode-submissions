class Solution {
    public int[] productExceptSelf(int[] nums) {

        final int[] result = new int[nums.length];

        // Populate powers from right-to-left
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = product;
            product *= nums[i];
        }

        // [ 1,  2,  4,  6] (nums)
        // [48, 24,  6,  1] (result)
        // ( 1,  1,  2,  8) (product)
        // [48, 24, 12,  8] result

        // Calculate from left-to-right
        product = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = product * result[i];
            product *= nums[i];
        }

        return result;
    }
}  
