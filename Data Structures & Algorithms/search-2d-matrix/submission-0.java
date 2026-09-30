class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int length = n * m;

        int l = 0;
        int r = length - 1;
        while (l <= r) {
            final int partition = l + ((r - l) / 2);
            final int row = partition / n;
            final int col = partition % n;
            final int val = matrix[row][col];
            if (val == target) return true;
            if (val < target) {
                l = partition + 1;
            } else {
                r = partition - 1;
            }
        }

        return false;
    }
}
