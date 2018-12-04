import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums,  boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                // 这里used[i - 1]和!used[i - 1]都可以
                if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                    continue;
                }
                temp.add(nums[i]);
                used[i] = true;
                backtrack(list, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }
}
