class Solution {
    // Find all unique subsets in an array containing duplicate numbers
    // Note this implementation mutates the nums array (sorts).
    public List<List<Integer>> subsetsWithDup(final int[] nums) {

        // Sort the array so we can guarantee order
        Arrays.sort(nums);

        final List<List<Integer>> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void backtrack(
        final int i,
        final List<Integer> subset,
        final int[] nums,
        final List<List<Integer>> result
    ) {
        // If we have reached the end of the array then add the subset
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Otherwise...

        // Choose this item and continue
        subset.add(nums[i]);
        backtrack(i + 1, subset, nums, result);

        // .. or backtrack and skip to next unique value
        subset.remove(subset.size() - 1);
        int delta = 0;
        while (i + delta + 1 < nums.length && nums[i] == nums[i + delta + 1]) {
            delta++;
        }
        backtrack(i + delta + 1, subset, nums, result);
    }
}
