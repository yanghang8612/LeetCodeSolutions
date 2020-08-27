package standard;

import java.util.Arrays;
import java.util.Stack;

public class N071_SimplifyPath {

    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String folder : folders) {
            if (!folder.isEmpty()) {
                if ("..".equals(folder)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!".".equals(folder)) {
                    stack.push(folder);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new N071_SimplifyPath().simplifyPath("a"));;
    }
}
