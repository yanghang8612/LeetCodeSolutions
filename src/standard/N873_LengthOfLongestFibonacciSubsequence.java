package standard;

import java.util.HashMap;
import java.util.Map;

public class N873_LengthOfLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[A.length][A.length];
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            map.put(A[i], i);
            for (int j = i - 1; j > 0; j--) {
                int k = map.getOrDefault(A[i] - A[j], -1);
                dp[j][i] = A[i] < 2 * A[j] && k > 0 ? dp[k][j] + 1 : 2;
                max = Math.max(max, dp[j][i]);
            }
        }
        return max > 2 ? max : 0;
    }

    public static void main(String[] args) {

    }
}
