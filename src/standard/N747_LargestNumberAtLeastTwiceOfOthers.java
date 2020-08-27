package standard;

public class N747_LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int max1 = nums[1] < nums[0] ? 1 : 0;
        int max2 = nums[1] > nums[0] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max1]) {
                if (nums[i] >= nums[max2]) {
                    max1 = max2;
                    max2 = i;
                } else {
                    max1 = i;
                }
            }
        }
        return nums[max2] >= 2 * nums[max1] ? max2 : -1;
    }

    public static void main(String[] args) {
        System.out.println(new N747_LargestNumberAtLeastTwiceOfOthers().dominantIndex(new int[]{0,0,2,3}));
    }
}
