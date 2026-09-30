class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPurchasePrice = prices[0];

        for (int sellPrice : prices) {
            final int profit = sellPrice - minPurchasePrice;
            maxProfit = Math.max(maxProfit, profit);
            minPurchasePrice = Math.min(minPurchasePrice, sellPrice);
        }

        return maxProfit;
    }
}
