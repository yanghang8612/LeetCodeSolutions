import java.util.*;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Character> opr = new Stack<>();
        Stack<Integer> opd = new Stack<>();
        List<Character> l = Arrays.asList('(', '+', '-', ')');
        int[][] pri = new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };
        s = s.replaceAll("\\s+", "");
        s = s + ')';
        opr.push('(');
        int a = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (a == -1) a = 0;
                a = a * 10 + c - '0';
            } else {
                if (a != -1) {
                    opd.push(a);a = -1;
                }
                char pre = opr.peek();
                if (pri[l.indexOf(pre)][l.indexOf(c)] == 1) {
                    if (pre == '+' || pre == '-') {
                        opr.pop();
                        opd.push((pre == '+' ? opd.pop() : -opd.pop()) + opd.pop());
                    }
                    if (c != ')') {
                        opr.push(c);
                    } else if (opr.peek() == '(') {
                        opr.pop();
                    }
                } else {
                    opr.push(c);
                }
            }
        }
        return opd.peek();
    }

    public int calculate2(String s) {
        if (s == null) return 0;
        int res = 0, sign = 1, num = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                 res += sign * num;
                 sign = stack.peek() * (c == '+' ? 1 : -1);
                 num = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }
        res += sign * num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1)"));
    }
}
