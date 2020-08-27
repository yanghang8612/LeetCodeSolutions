package standard;

import java.util.Arrays;

public class N475_Heaters {

    public int findRadius(int[] h, int[] w) {
        Arrays.sort(h);
        Arrays.sort(w);
        int idx = 0, min = Integer.MIN_VALUE;
        for (int i = 0; i < h.length; i++) {
            if (h[i] < w[idx] || idx == w.length - 1) {
                min = Math.max(min, Math.abs(w[idx] - h[i]));
            } else if (h[i] < w[idx + 1]) {
                min = Math.max(min, Math.min(h[i] - w[idx], w[idx + 1] - h[i]));
            } else {
                idx += 1;
                i -= 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
