class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        complements = {}

        for idx, val in enumerate(nums):
            complement = target - val
            if complement in complements:
                return [complements[complement], idx]
            complements[val] = idx
        
        return []