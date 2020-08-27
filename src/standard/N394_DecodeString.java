package standard;

import java.util.Stack;

public class N394_DecodeString {

    public String decodeString(String s) {
        if (!s.contains("[")) return s;
        s = "1[" + s + "]";
        Stack<String> stack = new Stack<>();
        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (letter.length() != 0) {
                    stack.push(letter.toString());
                    letter.setLength(0);
                }
                stack.push("*" + digit.toString());
                digit.setLength(0);
            } else if (c == ']') {
                while (!stack.peek().startsWith("*")) {
                    letter.insert(0, stack.pop());
                }
                int times = Integer.parseInt(stack.pop().substring(1));
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    res.append(letter.toString());
                }
                stack.push(res.toString());
                letter.setLength(0);
            } else {
                if (Character.isDigit(c)) {
                    digit.append(c);
                } else {
                    letter.append(c);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new N394_DecodeString().decodeString("ef3[a]ef2[bc]shabi"));
    }
}
