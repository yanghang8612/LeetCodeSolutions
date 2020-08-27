/**
 * rob(int[], int, int)函数可以使用HouseRobber中的rob2函数替换，可以获得o(1)的空间复杂度
 */

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        return Math.max(nums[0] + rob(nums, 2, n - 1), rob(nums, 1, n));
    }

    public int rob(int[] nums, int s, int e) {
        if (s >= nums.length || e > nums.length || s == e) return 0;
        int n = e - s;
        int[] dp = new int[n + 1];
        dp[1] = nums[s];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[s + i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2,3,2}));
    }
}
