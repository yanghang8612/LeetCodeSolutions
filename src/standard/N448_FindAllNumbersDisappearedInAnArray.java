package standard;

import java.util.ArrayList;
import java.util.List;

public class N448_FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
                i -= 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N448_FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
