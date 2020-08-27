package standard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class N077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int s, List<Integer> l) {
        if (l.size() == k) {
            res.add(new ArrayList<>(l));
            return;
        }
        for (int i = s; i <= n; i++) {
            l.add(i);
            dfs(res, n, k, i + 1, l);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal(0.1));
    }
}
