import java.util.Arrays;

/**
 * sabi了，这题返回结果最大也就n，因此可以用桶排序，大于等于n的统一放到一个桶里，0~n-1的放到对应桶里
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int n = citations.length, i = 0; i < n; i++) {
            if (citations[i] >= n - i) return n - i;
        }
        return 0;
    }

    public int hIndexByBucket(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; i++) {
            bucket[Math.min(citations[i], n)] += 1;
        }
        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += bucket[i];
            if (cnt >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndexByBucket(new int[]{3,0,6,1,5}));
    }
}
