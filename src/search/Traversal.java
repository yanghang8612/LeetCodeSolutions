package search;

public class Traversal implements Sortable {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] += 1;
        }
    }
}
