package standard;

import java.util.ArrayList;
import java.util.List;

public class N282_ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, target, new StringBuilder(""), res, 0, 0, 0);
        return res;
    }

    public void helper(String num, int target, StringBuilder path, List<String> res, int pos, long cur, long last) {
        if (pos == num.length()) {
            if (cur == target) {
                res.add(path.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            long a = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            if (pos == 0) {
                helper(num, target, path.append(a), res, i + 1, a, a);
                path.setLength(len);
            } else {
                helper(num, target, path.append("+").append(a), res, i + 1, cur + a, a);
                path.setLength(len);
                helper(num, target, path.append("-").append(a), res, i + 1, cur - a, -a);
                path.setLength(len);
                helper(num, target, path.append("*").append(a), res, i + 1, cur - last + last * a, last * a);
                path.setLength(len);
            }
            if (0 == a) break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new N282_ExpressionAddOperators().addOperators("006", 6));
    }
}
