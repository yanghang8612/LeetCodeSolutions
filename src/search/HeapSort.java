package search;

public class HeapSort implements Sortable {

    @Override
    public void sort(int[] a) {
        int n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) { //构建大顶堆
            sink(a, i, n);
        }
        while (n > 0) {
            swap(a, 0, n--); // 将堆顶最大元素交换到数组末尾
            sink(a, 0, n); // 由于交换了末尾元素,所以将其下沉
        }
    }

    /**
     * 注意,不管是大顶堆还是小顶堆在初始构建的过程中是采用下沉的操作,
     * 在删除最大元素的过程中也是采用下沉的方式,在插入的过程中采用上浮的方式
     */
    private void sink(int[] a, int k, int n) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j < n && a[j] < a[j + 1]) j += 1;
            if (a[k] >= a[j]) break;
            swap(a, k, j);
            k = j;
        }
    }
}
