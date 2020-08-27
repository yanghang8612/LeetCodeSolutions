import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        res[0] = findMax(nums, 0, k);
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i + k - 1] >= res[i - 1]) {
                res[i] = nums[i + k - 1];
            } else if (nums[i - 1] < res[i - 1]) {
                res[i] = res[i - 1];
            } else {
                res[i] = findMax(nums, i, i + k);
            }
        }
        return res;
    }

    private int findMax(int[] nums, int s, int e) {
        int max = Integer.MIN_VALUE;
        for (int i = s; i < e; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int[] maxSlidingWindowByFirstDiscussion(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return nums;
        int n = nums.length;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i - k + 1 >= 0) res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
