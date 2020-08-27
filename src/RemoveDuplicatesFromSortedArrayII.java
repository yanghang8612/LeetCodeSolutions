import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

public int removeDuplicates(int[] nums) {
    if (nums == null) return 0;
    int count = 0;
    for (int num : nums)
        if (count < 2 || num > nums[count - 2])
            nums[count++] = num;
    return count;
}

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3};
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
