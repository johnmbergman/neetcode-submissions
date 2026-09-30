class Solution {
    public List<List<Integer>> combinationSum(final int[] nums, final int target) {

        // Sort the array to allow us to return early
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, 0, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(
        final int[] sortedNums,
        final int target,
        final int i,
        final List<List<Integer>> result,
        final List<Integer> combination,
        final int sum
    ) {
        // Check if we have met the target
        // We don't need to proceed due to constraints >= 2
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Otherwise check against current and all future values
        for (int j = i; j < sortedNums.length; j++) {
            final int curr = sortedNums[j];
            if (sum + sortedNums[j] > target) return;
            combination.add(curr);
            dfs(sortedNums, target, j, result, combination, sum + curr);
            combination.remove(combination.size() - 1);
        }
    }
}
