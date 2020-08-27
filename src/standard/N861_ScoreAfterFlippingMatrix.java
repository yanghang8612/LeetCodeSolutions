package standard;

public class N861_ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int n = A.length, m = A[0].length;
        int[] inc = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = (int) Math.pow(2, m - j - 1);
                cur *= A[i][j] == 0 ? 1 : -1;
                inc[i] += cur;
                inc[n + j] += cur;
            }
        }
        while (true) {
            int i = 0;
            for (int k = 0; k < n + m; k++) {
                i = inc[k] > inc[i] ? k : i;
            }
            if (inc[i] > 0) {
                inc[i] = -inc[i];
                if (i < n) {
                    for (int j = 0; j < m; j++) {
                        A[i][j] = A[i][j] == 0 ? 1 : 0;
                        int cur = (int) Math.pow(2, m - j - 1);
                        cur *= A[i][j] == 0 ? 1 : -1;
                        inc[n + j] += 2 * cur;
                    }
                } else {
                    i -= n;
                    for (int j = 0; j < n; j++) {
                        A[j][i] = A[j][i] == 0 ? 1 : 0;
                        int cur = (int) Math.pow(2, m - i - 1);
                        cur *= A[j][i] == 0 ? 1 : -1;
                        inc[j] += 2 * cur;
                    }
                }
            } else {
                return decode(A);
            }
        }
    }

    private int decode(int[][] m) {
        int res = 0;
        for (int[] row : m) {
            for (int j = 0; j < m[0].length; j++) {
                res += Math.pow(2, m[0].length - 1 - j) * row[j];
            }
        }
        return res;
    }

    public int matrixScoreSimple(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int n = A.length, m = A[0].length, res = (1 << m - 1) * n;
        for (int j = 1; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += A[i][0] == A[i][j] ? 1 : 0;
            }
            res += Math.max(cnt, n - cnt) * (1 << m - 1 - j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N861_ScoreAfterFlippingMatrix().matrixScoreSimple(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}
