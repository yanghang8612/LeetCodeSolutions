package search;

public class ShellSort implements Sortable {

    @Override
    public void sort(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < n - gap; i++) {
                int cur = a[i + gap], j = i;
                while (j >= 0 && a[j] > cur) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = cur;
            }
        }
    }
}
