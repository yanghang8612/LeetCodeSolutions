package standard;

import java.util.Stack;

public class N739_DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res =  new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && T[i] > T[s.peek()]) {
                int idx = s.pop();
                res[idx] = i - idx;
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
