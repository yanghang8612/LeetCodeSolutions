public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = nums[i];
            if (count >= s) {
                return 1;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    count += nums[j];
                    if (count >= s) {
                        min = Integer.min(min, i - j + 1);
                        break;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int sum = 0, from = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Integer.min(min, i - from + 1);
                sum -= nums[from++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen2(15, new int[]{1,2,3,4,5}));
    }
}
