import java.util.Arrays;

/**
 * MaximumGap应该不会比 (max - min) / (nums.length - 1) 更小
 * 将其称为minGap，则以minGap为步进划分出nums.length - 1个buckets，从而进行桶排序
 * 每个桶内只需要记录其单独的min和max即可，因为桶内的元素之间的Gap一定比minGap小，从而无法成为MaximumGap
 */

public class MaximumGap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int minGap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketsMin = new int[nums.length - 1];
        int[] bucketsMax = new int[nums.length - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / minGap;
            bucketsMin[index] = Math.min(bucketsMin[index], num);
            bucketsMax[index] = Math.max(bucketsMax[index], num);
        }
        int maxGap = Integer.MIN_VALUE, pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }
        return Math.max(maxGap, max - pre);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumGap().maximumGap(new int[]{1,1,1,1}));
    }
}
