import java.util.Arrays;
import java.util.Random;

public class Sort {

    private void selectionSort(int[] a, int lo, int hi){

    }

    private void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a[j - 1] > a[j]; j--) {
                swap(a, j - 1, j);
            }
        }
    }

    private void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int v = a[lo], i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < v && i < hi);
            while (a[--j] > v);
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    private void quickSort2(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int v = a[lo], i = lo, j = hi + 1;
        while (true) {
            while (a[--j] > v);
            swap(a, ++i, j);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length && i < b.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            int[] nums = new int[(int) Math.pow(10, i)];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = new Random().nextInt(nums.length);
            }
            System.out.println("Array size: " + nums.length);
            int[] officialCopy = Arrays.copyOf(nums, nums.length);
            long start = System.currentTimeMillis();
            Arrays.sort(officialCopy);
            System.out.println("Array.sort() cost: " + (System.currentTimeMillis() - start) + "ms");
            int[] myQuickCopy = Arrays.copyOf(nums, nums.length);
            start = System.currentTimeMillis();
            new Sort().quickSort(myQuickCopy, 0, myQuickCopy.length - 1);
            System.out.println("quickSort cost: " + (System.currentTimeMillis() - start) + "ms and result is " + check(officialCopy, myQuickCopy));
            int[] myInsertionCopy = Arrays.copyOf(nums, nums.length);
            start = System.currentTimeMillis();
            new Sort().insertionSort(myInsertionCopy, 0, myInsertionCopy.length - 1);
            System.out.println("insertionSort cost: " + (System.currentTimeMillis() - start) + "ms and result is " + check(officialCopy, myInsertionCopy));

        }
    }
}
