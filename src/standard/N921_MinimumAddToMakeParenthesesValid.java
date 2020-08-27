package standard;

import java.util.ArrayDeque;
import java.util.Deque;

public class N921_MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (c == '(' || stack.isEmpty() || stack.peek() == ')') stack.push(c);
            else stack.pop();
        }
        return stack.size();
    }

    class A implements Cloneable  {

        String name;

        public A clone() {
            A a = null;
            try {
                a = (A) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return a;
        }

    }

    private void test() {
        A a = new A();
        a.name = "shabi";
        A b = a.clone();
        a.name = "erbi";
        System.out.println(a.name == b.name);
    }

    public static void main(String[] args) {
        new N921_MinimumAddToMakeParenthesesValid().test();
    }
}
