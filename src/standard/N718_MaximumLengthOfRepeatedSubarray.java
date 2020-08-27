package standard;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class N718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, res = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                dp[j] = A[j - 1] == B[i] ? pre + 1 : 0;
                res = Math.max(res, dp[j]);
                pre = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N718_MaximumLengthOfRepeatedSubarray());
    }
}
