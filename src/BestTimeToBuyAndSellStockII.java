import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockII {

public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
        return 0;
    }
    int low = prices[0], high = prices[0];
    int count = 0;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] >= high) {
            high = prices[i];
        } else {
            count += (high - low);
            low = high = prices[i];
        }
    }
    return count + (high > low ? high - low : 0);
}

    public static void main(String[] args) {
//        int a = 1;
//        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{a,2,4,1}));
        List<String> list = new ArrayList<>();
        list.add("shabi");
        list.add("erbi");
        list.add("gay");
        System.out.println(list.contains("shabi"));
        System.out.println(list.contains("erbier"));
        System.out.println(list.contains("gay"));
    }
}
