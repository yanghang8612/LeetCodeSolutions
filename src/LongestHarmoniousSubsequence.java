import java.util.*;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Integer.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
