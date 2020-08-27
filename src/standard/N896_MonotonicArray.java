package standard;

import java.util.Comparator;

public class N896_MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length < 3) return true;
        int n = A.length, flag = A[1] - A[0];
        for (int i = 1; i < A.length; i++) {
            if ((A[i] - A[i - 1]) * flag < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int[] A, int i, int j, Comparator<Integer> c) {
        if (j - i < 2) return c.compare(A[i], A[j]) <= 0;
        if (c.compare(A[i], A[j]) > 0) return false;
        int mid = i + (j - i) / 2;
        return helper(A, i, mid, c) && helper(A, mid, j, c);
    }

    public static void main(String[] args) {
        System.out.println(new N896_MonotonicArray().isMonotonic(new int[]{11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5}));
    }
}
