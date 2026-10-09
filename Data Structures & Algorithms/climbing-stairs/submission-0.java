class Solution {
    public int climbStairs(final int n) {
        int a = 1;
        int b = 1;

        for (int i = 0; i < n - 1; i++) {
            int tmp = a;
            a = a + b;
            b = tmp;
        }

        return a;
    }
}
