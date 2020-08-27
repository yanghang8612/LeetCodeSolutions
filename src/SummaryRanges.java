import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0], n = nums.length;
        for (int i = 1; i < n ; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                res.add(start == nums[i - 1] ? String.valueOf(start) : start + "->" + nums[i - 1]);
                start = nums[i];
            }
        }
        res.add(start == nums[n - 1] ? String.valueOf(start) : start + "->" + nums[n - 1]);
        return res;
    }

    public static void main(String[] args) {

    }
}
