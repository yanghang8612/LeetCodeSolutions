package standard;

import java.util.HashMap;
import java.util.Map;

public class N992_SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < A.length; j++) {
            if (map.getOrDefault(A[j], 0) == 0) K -= 1;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) K += 1;
                i += 1;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N992_SubarraysWithKDifferentIntegers().subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
}
