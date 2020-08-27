package standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 频率相关的题，一定注意数组中任意元素出现的次数最大为n，因此可以考虑开辟频度数组进行记录
 */
public class N347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int ele : buckets[i]) {
                    res[idx++] = ele;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
