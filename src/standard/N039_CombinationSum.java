package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target) {
        if (target == 0 && !temp.isEmpty()) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] < 0) break;
                temp.add(candidates[i]);
                backtrack(list, temp, candidates, i, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new N039_CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
