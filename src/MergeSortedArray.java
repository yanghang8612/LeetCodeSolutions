public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m-- + n--;
        for (int i = 1; i <= len; i++) {
            nums1[len - i] = (n < 0 || (m >= 0 && nums1[m] > nums2[n])) ? nums1[m--] : nums2[n--];
        }
    }

    public static void main(String[] args) {

    }
}
