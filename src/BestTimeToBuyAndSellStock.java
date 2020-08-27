public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int preMin = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (price < preMin)
                preMin = price;
            max = Math.max(max, price - preMin);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
