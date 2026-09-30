class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        k = len(nums)
        res = [1]*k

        # Populate left product
        res[0] = nums[0]
        for i in range(1, k):
            res[i] = res[i-1] * nums[i]

        # Track right product and update results
        right_product = 1
        for i in range(k-1, 0, -1): # TODO compute res[0]
            res[i] = right_product * res[i-1]
            right_product *= nums[i]
        res[0] = right_product
            
        return res