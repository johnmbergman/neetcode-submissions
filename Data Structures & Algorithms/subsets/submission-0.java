class Solution {

    /**
     * Finds all subsets within the provided input array.
     * Assumes that `nums` is a non-null array of unique integers.
     * The result will not contain duplicate subsets.
     */
    public List<List<Integer>> subsets(final int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, result, subset);
        return result;
    }

    private void dfs(
        final int[] nums,
        final int i,
        final List<List<Integer>> result,
        final List<Integer> subset
    ) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Include next
        subset.add(nums[i]);
        dfs(nums, i+1, result, subset);
        // Exclude next
        subset.remove(subset.size() - 1);
        dfs(nums, i+1, result, subset);
    }
}
