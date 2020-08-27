package standard;

public class N540_SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) j = mid;
                else i = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) i = mid;
                else j = mid - 1;
            }
            else return nums[mid];
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new N540_SingleElementInASortedArray().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
