package standard;

import java.util.Arrays;

public class N075_SortColors {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length, oneEnd = 0, twoStart = n - 1;
        for (int i = oneEnd; i <= twoStart; i++) {
            if (nums[i] == 0 && i != oneEnd) {
                nums[i--] = nums[oneEnd];
                nums[oneEnd++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[twoStart];
                nums[twoStart--] = 2;
            }
        }
     }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,0};
        new N075_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
