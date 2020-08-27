package standard;

/**
 * 这题主要是层级的划分，采用BFS的想法，把数组划分成一层一层的
 * 每层的元素都能通过上一层的某些节点前进一步到达
 * 这样的话，找到每一层元素所能到达的最大位置（i + nums[i])即是下一层的结束位置
 */
public class N045_JumpGameII {

    public int jump(int[] nums) {
        int step = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                step += 1;
                curEnd = curFarthest;
            }
        }
        return step;
    }

    public static void main(String[] args) {

    }
}
