public class BurstBalloons {

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int num : iNums) nums[n++] = num;
        nums[0] = nums[n++] = 1;

        int[][] mem = new int[n][n];
        return burst(mem, nums, 0, n - 1);
    }

    private int burst(int[][] mem, int[] nums, int left, int right) {
        if (right - left == 1) return 0;
        if (mem[left][right] > 0) return mem[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++) { // 注意这里是left + i + right，因为
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(mem, nums, left, i) + burst(mem, nums, i, right));
        }
        mem[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
