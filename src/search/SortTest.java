package search;

import java.util.Random;

public class SortTest {

    private int[] test(Sortable s, int[] a) {
        long startTime = System.nanoTime();
        s.sort(a);
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.format("-%s:%fms", s.getClass().getSimpleName(), (float) elapsedNanos / 1000 / 1000);
        return a;
    }

    private void testAll(Sortable[] ss, int[] a, int[] r) {

    }

    private boolean check(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int[] a = new int[10];
            Random rd = new Random();
            for (int j = 0; j < a.length; j++) {
                a[j] = rd.nextInt() % 20;
            }
            SortTest t = new SortTest();
//            System.out.println(a + " " + t.check(t.test(new Traversal(), a.clone())));
//            System.out.println(" " + t.check(t.test(new BubbleSort(), a.clone())));
//            System.out.println(" " + t.check(t.test(new SelectionSort(), a.clone())));
//            System.out.println(" " + t.check(t.test(new InsertionSort(), a.clone())));
//            System.out.println(" " + t.check(t.test(new ShellSort(), a.clone())));
//            System.out.println(" " + t.check(t.test(new MergeSort(), a.clone())));
//            System.out.println(" " + t.check(t.test(new QuickSort(), a.clone())));
            System.out.println(" " + t.check(t.test(new HeapSort(), a.clone())));
        }

    }
}
