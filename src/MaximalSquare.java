public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] dp = new int[matrix[0].length + 1];
        int maxLen = 0;
        for (char[] row : matrix) {
            int pre = 0;
            for (int i = 1; i <= row.length; i++) {
                int l = row[i - 1] == '1' ? Math.min(pre, Math.min(dp[i - 1], dp[i])) + 1 : 0;
                pre = dp[i];
                dp[i] = l;
                maxLen = Math.max(maxLen, l);
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}}));
    }
}
