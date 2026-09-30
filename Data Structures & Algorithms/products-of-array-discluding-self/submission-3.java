class Solution {
    public int[] productExceptSelf(int[] nums) {

        final int[] products = new int[nums.length];
        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            products[i] = product;
        }

        product = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            products[i] = product * products[i+1];
            product *= nums[i];
        }
        products[nums.length - 1] = product;

        return products;
    }
}  
