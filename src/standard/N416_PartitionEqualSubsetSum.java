package standard;

public class N416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int s = sum / 2; s > 0; s--) {
                if (s >= num) {
                    dp[s] = dp[s] || dp[s - num];
                }
            }
            if (dp[sum / 2]) return true;
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        System.out.println(new N416_PartitionEqualSubsetSum().canPartition(new int[]{1,5,11,5}));
    }
}
