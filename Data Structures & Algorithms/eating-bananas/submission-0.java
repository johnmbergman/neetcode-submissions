class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int speed = right;

        while (left <= right) {
            final int k = (left + right) / 2;

            long totalTime = 0;
            for (int pile : piles) {
                totalTime += Math.ceil((double) pile / k);
            }

            if (totalTime <= h) {
                speed = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return speed;
    }
}
