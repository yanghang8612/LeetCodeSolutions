/**
 * 在非重复版本的基础上，针对nums[lo] == nums[mid]，将lo位置向前加1，当数组全相同时，算法退化为o(n)
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;
            if (nums[lo] < nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[lo] > nums[mid]) {
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else {
                lo++;
            }
        }
        return target == nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{1, 3, 4, 1, 1, 1, 1, 1, 1}, 3));
    }
}
