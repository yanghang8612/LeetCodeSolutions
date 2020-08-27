package standard;

public class N920_NumberOfMusicPlaylists {

    public int numMusicPlaylists(int N, int L, int K) {
        int m = (int) 1e9 + 7;
        long[] dp = new long[N + 1];
        dp[1] = N;
        for (int i = 2; i <= L; i++) {
            for (int j = N; j > 0; j--) {
                dp[j] = (dp[j - 1] * (N - j + 1) + dp[j] * Math.max(j - K, 0)) % m;
            }
        }
        return (int) dp[N];
    }

    public int NumMusicPlaylists(int N, int L, int K) {
        int MOD = (int)1e9 + 7;
        var dp = new long[N + 1];
        dp[1] = N;
        for (int p = 2; p <= L; p++) {
            for (int s = Math.min(N, p); s > 0; s--)
                dp[s] = (dp[s-1] * (N-s+1) + dp[s] * Math.max(s-K, 0)) % MOD;
        }

        return (int)dp[N];
    }

    public static void main(String[] args) {

    }
}
