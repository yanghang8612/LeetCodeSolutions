public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int begin, int end) {
        if (end - begin == 0) return nums[begin];
        int mid = (begin + end) / 2;
        if (nums[mid] > nums[begin]) {
            if (nums[mid] < nums[end])
                return nums[begin];
            else
                return findMin(nums, mid, end);
        } else {
           if (nums[mid] > nums[end])
               return nums[end];
           else
               return findMin(nums, begin, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
