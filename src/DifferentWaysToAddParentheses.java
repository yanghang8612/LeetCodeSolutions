import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                    for (Integer a : left) {
                        for (Integer b: right) {
                            switch (c) {
                                case '+':
                                    res.add(a + b);
                                    break;
                                case '-':
                                    res.add(a - b);
                                    break;
                                case '*':
                                    res.add(a * b);
                                    break;
                            }
                        }
                    }
                }
            }
        }
        map.put(input, res);
        return res;
    }

    public static void main(String[] args) {
        new DifferentWaysToAddParentheses().diffWaysToCompute("2+1*3-4");
    }
}
