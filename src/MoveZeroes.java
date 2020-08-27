import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int index = 0, n = nums.length;
        while (index < n && nums[index] != 0) index += 1;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        Arrays.fill(nums, index, n, 0);
    }

    public static void main(String[] args) {

    }
}
