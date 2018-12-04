public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int n = prices.length;
        int[] oneProfit = new int[n], twoProfit = new int[n];
        int max = prices[n - 1], min = prices[0];
        for (int i = 1; i < n; i++) {
            int j = n - 1 - i;
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[j]);
            oneProfit[i] = Math.max(oneProfit[i - 1], prices[i] - min);
            twoProfit[j] = Math.max(twoProfit[j + 1], max - prices[j]);
        }
        int totalMax = 0;
        for (int i = 0; i < n; i++) {
            totalMax = Math.max(totalMax, oneProfit[i] + twoProfit[i]);
        }
        return totalMax;
    }
}
