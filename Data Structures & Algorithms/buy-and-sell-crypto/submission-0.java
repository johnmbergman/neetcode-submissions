class Solution {

    // 7, 1, 5, 3, 6, 4
    // 7, 1, 1, 1, 1, 1
    // 7, 6, 6, 6, 6, 4
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = 1;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}
