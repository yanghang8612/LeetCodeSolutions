package standard;

public class N055_JumpGame {

    public boolean canJump(int[] nums) {
        int i = 0, reach = 0, n = nums.length;
        for (i = 0; i < n && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == n;
    }

    public static void main(String[] args) {

    }
}
