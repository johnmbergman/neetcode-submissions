class Solution {
        
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        if (m < n) {
            final int tmp = m;
            m = n;
            n = tmp;
        }

        long result = 1;
        int j = 1;
        for (int i = m; i < m + n - 1; i++) {
            result *= i;
            result /= j;
            j++;
        }

        return (int) result;
    }
}
