class Solution {

    /**
     * Searches [nums] for the [target] integer. Returns the index
     * of the location within the array, or -1 if not found.
     */
    public int search(final int[] nums, final int target) {
        if (nums == null) return -1;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            final int partition = l + ((r-l)/2);
            final int valueAtPartition = nums[partition];
            if (target == valueAtPartition) {
                return partition;
            } else if (target > valueAtPartition) {
                l = partition + 1;
            } else { // target < valueAtPartition
                r = partition - 1;
            }
        }

        return -1;
    }
}
