package standard;

import java.util.HashSet;
import java.util.Set;

public class N128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            int i = num, j = num + 1;
            while (set.contains(i)) set.remove(i--);
            while (set.contains(j)) set.remove(j++);
            maxLen = Math.max(maxLen, j - i - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new N128_LongestConsecutiveSequence().longestConsecutive(new int[]{100,1,200,3,4,2}));
    }
}
