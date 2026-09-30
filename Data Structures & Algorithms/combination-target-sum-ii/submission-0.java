class Solution {
    public List<List<Integer>> combinationSum2(final int[] candidates, final int target) {

        // Sort the array to ensure that duplicates appear next to each other and we can return early
        Arrays.sort(candidates);

        final List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(
        final int[] nums,
        final int target,
        final int i,
        final List<List<Integer>> result,
        final List<Integer> combination,
        final int sum
    ) {
        // Check if we have met the target
        if (sum == target) {
            // No need to continue checking since 1 <= nums[i] <= 50
            result.add(new ArrayList<>(combination));
            return;
        }

        // Otherwise, track through remaining numbers
        for (int j = i; j < nums.length; j++) {

            // Skip duplicates
            if (j > i && nums[j] == nums[j-1]) continue;
            final int curr = nums[j];
            if (sum + curr > target) break;

            combination.add(curr);
            dfs(nums, target, j+1, result, combination, sum + curr);
            combination.remove(combination.size() - 1);
        }
    }
}
