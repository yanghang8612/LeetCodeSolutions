public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int sell = 0, preSell, buy = -50000, preBuy;
        for (int price : prices) {
            preBuy = buy;preSell = sell;
            buy = Math.max(preSell - price, preBuy);
            sell = Math.max(preBuy + price - fee, preSell);
        }
        return sell;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
