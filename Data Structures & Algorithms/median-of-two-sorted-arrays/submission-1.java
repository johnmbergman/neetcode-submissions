class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        final int total = nums1.length + nums2.length;
        final int half = (total+1) / 2;

        // loop
        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            final int pivot1 = (left + right) / 2;
            final int pivot2 = half - pivot1;
            final int aleft = pivot1 > 0 ? nums1[pivot1-1] : Integer.MIN_VALUE;
            final int aright = pivot1 < nums1.length ? nums1[pivot1] : Integer.MAX_VALUE;
            final int bleft = pivot2 > 0 ? nums2[pivot2-1] : Integer.MIN_VALUE;
            final int bright = pivot2 < nums2.length ? nums2[pivot2] : Integer.MAX_VALUE;

            if (aleft <= bright && bleft <= aright) {
                if (total % 2 != 0) return Math.max(aleft, bleft);
                return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            } else if (aleft > bright) {
                right = pivot1 - 1;
            } else {
                left = pivot1 + 1;
            }
        }

        return -1;
    }
}
