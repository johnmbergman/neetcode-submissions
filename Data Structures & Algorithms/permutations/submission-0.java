class Solution {
    public List<List<Integer>> permute(final int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, new boolean[nums.length], result);
        return result;
    }

    private void backtrack(
        final List<Integer> permutation,
        final int[] nums,
        final boolean[] selected,
        final List<List<Integer>> result
    ) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!selected[i]) {
                permutation.add(nums[i]);
                selected[i] = true;
                backtrack(permutation, nums, selected, result);
                permutation.remove(permutation.size() - 1);
                selected[i] = false;
            }
        }
    }
}
