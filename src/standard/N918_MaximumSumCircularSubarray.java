package standard;

public class N918_MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int curBig = 0, curSmall = 0, total = 0;
        for (int a : A) {
            total += a;
            curBig = curBig < 0 ? a : curBig + a;
            max = Math.max(max, curBig);
            curSmall = curSmall > 0 ? a : curSmall + a;
            min = Math.min(min, curSmall);
        }
        return total == min ? max : Math.max(max, total - min);
    }

    public static void main(String[] args) {

    }
}
