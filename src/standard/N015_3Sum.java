package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类似于11题，需要理解从两边向里夹逼
 */
public class N015_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo += 1;
                        while (lo < hi && nums[hi - 1] == nums[hi]) hi -= 1;
                        lo += 1;hi -= 1;
                    } else if (nums[lo] + nums[hi] < sum) lo += 1;
                    else hi -= 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
