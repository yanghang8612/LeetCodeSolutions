package standard;

import java.util.Arrays;

public class N473_MatchsticksToSquare {

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 4 != 0) return false;
        target /= 4;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i += 1;
            j -= 1;
        }
        return dfs(nums, 0, target, target, target, target);
    }

    private boolean dfs(int[] nums, int i, int a1, int a2, int a3, int a4) {
        if (i == nums.length) {
            return a1 == 0 && a2 == 0 && a3 == 0 && a4 == 0;
        }
        boolean a1Res = false, a2Res = false, a3Res = false, a4Res = false;
        if (nums[i] <= a1) a1Res = dfs(nums, i + 1, a1 - nums[i], a2, a3, a4);
        if (!a1Res && nums[i] <= a2) a2Res = dfs(nums, i + 1, a1, a2 - nums[i], a3, a4);
        if (!a1Res && !a2Res && nums[i] <= a3) a3Res = dfs(nums, i + 1, a1, a2, a3 - nums[i], a4);
        if (!a1Res && !a2Res && !a3Res && nums[i] <= a4) a4Res = dfs(nums, i + 1, a1, a2, a3, a4 - nums[i]);
        return a1Res || a2Res || a3Res || a4Res;
    }

    private boolean dfs(int[] nums, int index, int tmp, int target, int group, boolean[] visited) {
        if (group == 4) return true;
        if (tmp > target) return false;
        if (target == tmp) return dfs(nums, 0, 0, target, group + 1, visited);

        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            if (dfs(nums, i + 1, tmp + nums[i], target, group, visited)) return true;
            visited[i] = false;
        }

        return false;
    }


    public static void main(String[] args) {

    }
}
