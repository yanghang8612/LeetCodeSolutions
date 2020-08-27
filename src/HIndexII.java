public class HIndexII {

    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (citations[m] == n - m) return n - m;
            else if (citations[m] > n - m) r = m - 1;
            else l = m + 1;
        }
        return 0;
    }
}
