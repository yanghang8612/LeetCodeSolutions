import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = nums[0]; i <= target; i++) {
            for (int num : nums) {
                dp[i] += i >= num ? dp[i - num] : 0;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1,2,3}, 1));
    }
}
