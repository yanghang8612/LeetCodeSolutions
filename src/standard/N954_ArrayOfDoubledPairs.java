package standard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N954_ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] A) {
        if (A == null || A.length == 0) return true;
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        int mid = -1;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] > 0 && A[i - 1] <= 0) mid = i;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        mid = mid != -1 ? mid : A[0] > 0 ? 0 : A.length - 1;
        for (int i = mid; i < A.length; i++) {
            if (map.getOrDefault(A[i], 0) != 0) {
                if (map.getOrDefault(A[i] * 2, 0) == 0) return false;
                map.put(A[i], map.get(A[i]) - 1);
                map.put(A[i] * 2, map.get(A[i] * 2) - 1);
            }
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (map.getOrDefault(A[i], 0) != 0) {
                if (map.getOrDefault(A[i] * 2, 0) == 0) return false;
                map.put(A[i], map.get(A[i]) - 1);
                map.put(A[i] * 2, map.get(A[i] * 2) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N954_ArrayOfDoubledPairs().canReorderDoubled(new int[]{1,2,1,-8,8,-4,4,-4,2,-2}));
    }

}
