import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!dir.equals(".") && !dir.isEmpty()) {
                stack.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        return (result.toString().isEmpty() ? "/" : result.toString());
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("."));
        System.out.println(simplifyPath(".."));
        System.out.println(simplifyPath("/a/./b/../../c/e"));
    }
}
