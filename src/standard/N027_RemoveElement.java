package standard;

public class N027_RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, cnt = 0, i = 0, j = n - 1;
        while (i < j) {
            while (i < j && nums[i] != val) i += 1;
            while (i < j && nums[j] == val) j -= 1;
            if (i < j) {
                nums[i++] = nums[j];
                nums[j--] = val;
            }
        }
        return nums[i] == val ? i : i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
    }

    public static void main(String[] args) {

    }
}
