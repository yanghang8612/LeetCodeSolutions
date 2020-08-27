public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int sell = 0, preSell = 0, buy = Integer.MIN_VALUE, preBuy;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);
        }
        return sell;
    }

    public static void main(String[] args) {

    }
}
