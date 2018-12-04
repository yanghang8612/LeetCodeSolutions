/**
 * 股票这个题通用解法是DP，dp[i][j]表示在0~j的price范围内进行i次交易所能取得的最大收益
 * 因此状态转移的考虑应该是在0~j-1范围内的交易i次的最大收益dp[i][j-1]与在第j位进行卖出的
 * 最大收益prices[j]-prices[jj]+dp[k-1][jj-1](jj取0~j-1)，其可以规约为prices[j]+max(dp[k-1][jj-1]-price[jj])(jj:0~j-1)
 * 而由于max(...)这部分可以在遍历的过程中不断更新以便给后续的dp使用，因此不需要
 */

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) return 0;
        int l = prices.length;
        if (k >= l / 2) {
            int maxProfit = 0, pre = prices[0];
            for (int cur : prices) {
                maxProfit += cur > pre ? cur - pre : 0;
                pre = cur;
            }
            return maxProfit;
        } else {
            int[][] dp = new int[k + 1][l];
            for (int i = 1; i <= k; i++) {
                int tmpMax = -prices[0];
                for (int j = 1; j < l; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                    tmpMax = Math.max(tmpMax, dp[i - 1][j] - prices[j]);
                }
            }
            return dp[k][l - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
