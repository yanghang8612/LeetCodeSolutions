package standard;

import java.util.HashMap;
import java.util.Map;

public class N560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
