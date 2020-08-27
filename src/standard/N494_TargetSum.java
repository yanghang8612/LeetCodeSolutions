package standard;

public class N494_TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S < -sum || S > sum) {
            return 0;
        }
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int num : nums) {
            int[] temp = new int[2 * sum + 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (dp[j] != 0) {
                    temp[j + num] += dp[j];
                    temp[j - num] += dp[j];
                }
            }
            dp = temp;
        }
        return dp[sum + S];
    }

    private int helper(int[] nums, int i, int S) {
        if (i == nums.length) return S == 0 ? 1 : 0;
        return helper(nums, i + 1, S - nums[i]) +
                helper(nums, i + 1, S + nums[i]);
    }

    public static void main(String[] args) {
        System.out.println(new N494_TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
