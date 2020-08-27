package standard;

import java.util.Stack;

public class N456_132Pattern {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // push aj before ai (i < j, ai < aj)
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.empty()) {
                    if (stack.peek() >= num) break;
                    stack.pop();
                    if (stack.pop() > num) return true;
                }
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new N456_132Pattern().find132pattern(new int[]{5,7,1,2,6}));
    }
}
