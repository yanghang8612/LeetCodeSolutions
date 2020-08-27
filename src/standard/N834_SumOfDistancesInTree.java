package standard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N834_SumOfDistancesInTree {

    private final List<Set<Integer>> tree = new ArrayList<>();

    private int[] count, res;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        count = new int[N];
        res = new int[N];
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        buildRes(0, -1);
        return res;
    }

    private void dfs(int root, int pre) {
        for (Integer i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root] += 1;
    }

    private void buildRes(int root, int pre) {
        for (Integer i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            buildRes(i, root);
        }
    }

    public static void main(String[] args) {

    }
}
