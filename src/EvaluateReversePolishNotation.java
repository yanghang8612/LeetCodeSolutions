import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int a, b;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    b = s.pop();a = s.pop();
                    s.push(a + b);
                    break;
                case "-":
                    b = s.pop();a = s.pop();
                    s.push(a - b);
                    break;
                case "*":
                    b = s.pop();a = s.pop();
                    s.push(a * b);
                    break;
                case "/":
                    b = s.pop();a = s.pop();
                    s.push(a / b);
                    break;
                default:
                    s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
    }
}
