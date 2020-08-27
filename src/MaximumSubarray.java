public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, temp = 0;
        for (int num : nums) {
            temp = temp < 0 ? num : temp + num;
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{4,-2,-1}));
    }
}
