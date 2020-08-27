public class FirstBadVersion {

    public boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (r - l == 1) return isBadVersion(l) ? l : r;
            if (isBadVersion(m)) r = m;
            else l = m;
        }
        return l;
    }
}
