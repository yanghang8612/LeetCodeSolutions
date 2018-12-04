public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi -= 1;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {

    }
}
