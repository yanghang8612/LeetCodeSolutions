import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> com, int start, int target, int k) {
        if (target == 0) {
            if (com.size() == k) res.add(new ArrayList<>(com));
        } else {
            for (int i = start; i < 10; i++) {
                if (target - i < 0) break;
                com.add(i);
                backtrack(res, com, i + 1, target - i, k);
                com.remove(com.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
