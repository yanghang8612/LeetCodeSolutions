package search;

public class SelectionSort implements Sortable {

    @Override
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                min = a[j] < a[min] ? j : min;
            }
            swap(a, i, min);
        }
    }
}
