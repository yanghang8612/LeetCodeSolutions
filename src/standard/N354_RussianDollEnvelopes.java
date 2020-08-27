package standard;

import java.util.Arrays;

public class N354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int n = envelopes.length, res = 0;
        int[] tail = new int[n];
        for (int[] envelope : envelopes) {
            int idx = Arrays.binarySearch(tail, 0, res, envelope[1]);
            if (idx < 0) idx = -(idx + 1);
            tail[idx] = envelope[1];
            res += res == idx ? 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N354_RussianDollEnvelopes().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}
