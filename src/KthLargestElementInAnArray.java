import java.util.Arrays;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int[] heap;
        if (k % 2 == 1) {
            heap = Arrays.copyOf(nums, k);
        } else {
            heap = Arrays.copyOf(nums, k + 1);
            heap[heap.length - 1] = Integer.MAX_VALUE;
        }
        for (int i = k / 2 - 1; i >= 0; i--) {
            sink(heap, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                sink(heap, 0);
            }
        }
        return heap[0];
    }

    private void sink(int[] nums, int i) {
        int l = i * 2 + 1, r = i * 2 + 2;
        if (r < nums.length) {
            int iv = nums[i], lv = nums[l], rv = nums[r];
            int max = Math.min(iv, Math.min(lv, rv));
            if (max == lv) {
                swap(nums, i, l);
                sink(nums, l);
            } else if (max == rv) {
                swap(nums, i, r);
                sink(nums, r);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // return the index of the kth smallest number
    int quickSelect(int[] a, int lo, int hi, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = lo, j = hi, pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if (m == k)     return i;
            // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k);
            // pivot is too small, so it must be on the right
        else            return quickSelect(a, i + 1, hi, k - m);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 20));
        for (int i = 1; i < 29; i++) {
            System.out.print(new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, i) + ",");
        }
    }
}
