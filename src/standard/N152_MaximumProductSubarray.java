package standard;

public class N152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int curMin = nums[0], curMax = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0){
                curMin = Math.min(nums[i], curMin * nums[i]);
                curMax = Math.max(nums[i], curMax * nums[i]);
            } else {
                int temp = curMin;
                curMin = Math.min(nums[i], curMax * nums[i]);
                curMax = Math.max(nums[i], temp * nums[i]);
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
