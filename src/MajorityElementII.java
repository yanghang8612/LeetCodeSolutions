import java.util.ArrayList;
import java.util.List;

/**
 * 这里需要注意的是关于初始值的选定
 * 另个备选的majority一定不能相同，如果数组里的元素均为这个相同的初始值，
 * 那么在第二次循环判定时会出现两个相同的结果
 */

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int m1 = 0, m2 = 1, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == m1) {
                count1++;
            } else if (num == m2) {
                count2++;
            } else if (count1 == 0) {
                m1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                m2 = num;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == m1) count1 += 1;
            if (num == m2) count2 += 1;
        }
        if (count1 > nums.length / 3) res.add(m1);
        if (count2 > nums.length / 3) res.add(m2);
        return res;
    }

    public static void main(String[] args) {

    }
}
