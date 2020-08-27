public class CountDifferentPalindromicSubsequences {

    private int M = 1000000007;
    private int mod = 1000000007;

    public int countPalindromicSubsequences(String S) {
//        int len = S.length();
//        int[] rightNext = new int[len], leftNext = new int[len], pre = new int[4];
//        pre[0] = pre[1] = pre[2] = pre[3] = -1;
//        for (int i = 0; i < len; i++) {
//            int index = S.charAt(i) - 'a';
//            leftNext[i] = pre[index];
//            pre[index] = i;
//        }
//        pre[0] = pre[1] = pre[2] = pre[3] = len;
//        for (int i = len - 1; i >=0 ; i--) {
//            int index = S.charAt(i) - 'a';
//            rightNext[i] = pre[index];
//            pre[index] = i;
//        }
//        int[][] dp = new int[len][len];
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = 1;
//        }
//        for (int k = 1; k < len; k++) {
//            for (int i = 0, j = i + k; j < len; i++, j++) {
//                if (S.charAt(i) != S.charAt(j)) {
//                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
//                } else {
//                    int iRightNext = rightNext[i], jLeftNext = leftNext[j];
//                    if (iRightNext < jLeftNext) {
//                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[iRightNext + 1][jLeftNext - 1];
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1] * 2 + (iRightNext == jLeftNext ? 1 : 2);
//                    }
//                }
//                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + M : dp[i][j] % M;
//            }
//        }
//        return dp[0][len - 1];
        char[] chars = S.toCharArray();
        int n = chars.length;
        int[] counts = new int[n];

        for(int i = 0; i < n; i++) {
            int char1 = chars[i] - 'a';
            counts[i] = 1;
            long sum = 0;
            int[] tmp = new int[26];

            for(int j = i - 1; j >= 0; j--) {
                int char2 = chars[j] - 'a';
                int count = counts[j];

                if (char1 == char2) {
                    counts[j] = (int)((sum + 2) % mod);
                }

                sum += count - tmp[char2];
                tmp[char2] = count;
            }
        }

        int[] nums = new int[26];

        for(int i = n - 1; i >= 0; i--) {
            nums[chars[i] - 'a'] = counts[i];
        }

        long sum = 0;

        for(int cnt : nums) {
            sum += cnt;
        }

        return (int)(sum % mod);
    }

    public static void main(String[] args) {
        System.out.println(new CountDifferentPalindromicSubsequences().countPalindromicSubsequences("bccb"));
    }
}
