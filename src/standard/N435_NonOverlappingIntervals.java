package standard;

import java.util.Arrays;
import java.util.Comparator;

public class N435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                cnt += 1;
            }
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        System.out.println(new N435_NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
