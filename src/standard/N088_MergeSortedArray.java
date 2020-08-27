package standard;

public class N088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int len = m + n - 1;
        while (m != 0 || n != 0) {
            if (n == 0 || m != 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[len--] = nums1[m-- - 1];
            } else {
                nums1[len--] = nums2[n-- - 1];
            }
        }
    }

    public static void main(String[] args) {

    }
}
