package search;

public class MergeSort implements Sortable {

    private int[] aux;

    @Override
    public void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
//        if (hi <= lo) {
//            return;
//        } else {
        if (hi - lo < 15) { // 长度小于15的数组采用插入排序
            insertionSort(a, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }

    private void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] <= aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    private void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            int cur = a[i + 1], j = i;
            while (j >= lo && a[j] > cur) {
                a[j + 1] = a[j];
                j -= 1;
            }
            a[j + 1] = cur;
        }
    }
}
