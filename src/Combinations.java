import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用分治的办法的话，考虑n个元素的最后一个元素也即第n个元素，如果组合包含它，也就是在前n-1个元素中挑k-1个：C(n-1,k-1)
 * 如果组合不包含它，那么就是在前n-1个元素中挑k个：C(n-1,k)，合起来就是C(n)=C(n-1,k-1)+C(n-1,k)，以此等式做递归可得解
 *
 * 用回溯的话，我提交采用的方式是留存一个当前搜索路径的副本，每次搜索到尽头时，会向前返回一层而后继续搜索
 *
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return res;
        Integer[] c = new Integer[k];
        for (int i = 0; i < k; i++) {
            c[i] = i + 1;
        }
        while (true) {
            res.add(new ArrayList<>(Arrays.asList(c)));
            int index = -1;
            for (int i = k - 1; i >= 0 ; i--) {
                if (c[i] < n - k + 1 + i) {
                    c[i]++;index = i;
                    break;
                }
            }
            if (index == -1) break;
            for (int i = index + 1; i < k; i++) {
                c[i] = c[index] + i - index;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(1000, 2));
    }
}
