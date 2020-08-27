import java.util.*;

/**
 * 这个题其实需要理解一点，就是关于括号的匹配问题
 * 从这个BFS算法的isValid方法可以看出，其实括号匹配问题就是在遍历过程中看左括号和右括号是否一致
 * 遍历过程中出现右括号大于左括号的情况或者遍历完成后出现左括号大于右括号意味着该串非法
 * 那么括号匹配问题可以转化为删除多余的右括号，然后反转字符串再删除多余的左括号的问题了
 * 要想明白的是，当遍历到一个位置当前右括号比左括号多一个时，删除该串中的任意一个位置的右括号都能是串合法！
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        while (!q.isEmpty()) {
            s = q.poll();
            if (isValid(s)) {
                res.add(s);
            } else if (res.isEmpty()) {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == '(' || c == ')') {
                        String t = s.substring(0, i) + s.substring(i + 1);
                        if (!visited.contains(t)) {
                            q.offer(t);
                            visited.add(t);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt += 1;
            else if (s.charAt(i) == ')') {
                if (cnt == 0) return false;
                cnt -= 1;
            }
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParenthesesByDFS(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void remove(String s, List<String> res, int iStart, int jStart, char[] pattern) {
        // 只有当这个循环做完，并且没有return时，意味着找到了一个没有多余右括号的串
        // 并且搜索到这个时候才进行下面的反序的检验或加入res集合，这体现了深搜
        for (int cnt = 0, i = iStart; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pattern[0]) cnt += 1;
            else if (c == pattern[1]) cnt -= 1;
            if (cnt < 0) {
                for (int j = jStart; j <= i; j++) { // 注意 j<=i
                    if (s.charAt(j) == pattern[1] && (j == jStart || s.charAt(j - 1) != pattern[1])) {
                        remove(s.substring(0, j) + s.substring(j + 1), res, i, j, pattern);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pattern[0] == '(')
            remove(reversed, res, 0, 0, new char[]{')', '('});
        else
            res.add(reversed);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(")("));
    }
}
