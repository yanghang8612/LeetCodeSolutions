package standard;

import java.util.Arrays;

public class N080_RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[cnt++] = nums[i];
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    nums[cnt++] = nums[i++];
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new N080_RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));;
        System.out.println(Arrays.toString(nums));
    }
}
