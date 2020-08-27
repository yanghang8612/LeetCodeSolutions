/**
 *
 */

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        return rob(nums, 0, nums.length);
    }

    public int rob(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j < hi; j++) {
            int i = include, e = exclude;
            include = exclude + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob2(new int[]{2,3,2}));
    }
}
