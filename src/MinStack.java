import java.util.Stack;

public class MinStack {

    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
        stack.push((long) Integer.MAX_VALUE);
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x - min);
        min = Math.min(x, min);
    }

    public void pop() {
        if (stack.size() == 1) return;
        long pop = stack.pop();
        if (pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        return top < 0 ? (int) min : (int) (top + min);
    }

    public int getMin() {
        return (int) min;
    }
}
