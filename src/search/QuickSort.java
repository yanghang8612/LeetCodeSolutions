package search;

public class QuickSort implements Sortable {

    @Override
    public void sort(int[] a) {
//        Arrays.sort(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 感觉这里可以针对重复切分元素做优化,分别从切分元素的位置j往前往后找到第一个不同的元素作为递归调用的结束位置和开始位置;
     * 以上说法不准确,应该说切分过程中的数组里的切分元素是在不断的前后移动的,因此中间不一定就是切分元素的聚集
     */
    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 为什么返回j,因为终止条件i>=j,要么i=j,返回ij都可以,要么i>j,意味着j已经达到了小于切分元素序列的尾部,
     * 而切分元素是放在小于切分元素序列的首部,那应该该切分元素应该和j位置的元素交换,才不破坏切分的有序性
     */
    private int partition(int[] a, int lo, int hi) {
        int i = lo + 1, j = hi;
        int v = a[lo];
        while (true) {
            while (a[i] < v && i < hi) i += 1;
            while (a[j] > v && j > lo) j -= 1;
            if (i >= j) break;
            swap(a, i++, j--); // 注意这里要移动首尾下标,避免死循环
        }
//        int i = lo, j = hi + 1;
//        int v = a[lo];
//        while (true) {
//            while (a[++i] < v) if (i == hi) break;
//            while (v < a[--j]) if (j == lo) break;
//            if (i >= j) break;
//            swap(a, i, j);
//        }
        swap(a, lo, j);
        return j;
    }
}
