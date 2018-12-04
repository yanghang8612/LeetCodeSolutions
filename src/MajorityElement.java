/**
 * 唉，思维有点僵化~
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count += 1;
                majority = nums[i];
            } else if (majority == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {

    }
}
