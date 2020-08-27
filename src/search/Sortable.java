package search;

public interface Sortable {

    void sort(int[] a);

    default void swap(int[] a, int i, int j) {
//        if (i != j) {
//            a[i] ^= a[j];
//            a[j] ^= a[i];
//            a[i] ^= a[j];
//        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
