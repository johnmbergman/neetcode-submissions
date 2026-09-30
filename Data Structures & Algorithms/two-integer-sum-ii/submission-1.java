class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;

        while (b > a) {
            final int sum = numbers[a] + numbers[b];
            if (sum == target) {
                return new int[] { a+1, b+1 };
            } else if (sum > target) {
                b--;
            } else { /* sum < target */
                a++;
            }
        }

        throw new RuntimeException("No solution");
    }
}
