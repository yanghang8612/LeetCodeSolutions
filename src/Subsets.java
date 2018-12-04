import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 提交思路采用分治，C(n)=C(n-1)+C(n-1)
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public List<List<Integer>> subsets(int[] nums, int n) {
        if (n == 1) {
            List<List<Integer>> row = new ArrayList<>();
            row.add(new ArrayList<>());
            row.add(new ArrayList<>(Collections.singletonList(nums[0])));
            return row;
        }
        List<List<Integer>> result = subsets(nums, n - 1);
        List<List<Integer>> copy = new ArrayList<>();
        for (List<Integer> item : result) {
            copy.add(new ArrayList<>(item));
        }
        copy.forEach(e -> e.add(nums[n - 1]));
        result.addAll(copy);
        return result;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 2}));
    }
}
