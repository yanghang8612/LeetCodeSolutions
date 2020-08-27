package search;

public class InsertionSort implements Sortable {

    @Override
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int cur = a[i + 1], j = i;
            while (j >= 0 && a[j] > cur) {
                a[j + 1] = a[j];
                j -= 1;
            }
            a[j + 1] = cur;
        }
    }
}
