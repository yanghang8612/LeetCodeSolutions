package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N017_LetterCombinationsOfAPhoneNumber {

    private String[][] map = new String[][]{
            {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
            {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"},
            {"t", "u", "v"}, {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        if (digits.length() == 1) return Arrays.asList(map[Integer.parseInt(digits) - 2]);
        List<String> sub = letterCombinations(digits.substring(1)), res = new ArrayList<>();
        for(String base : map[digits.charAt(0) - '2']) {
            for (String rest : sub) {
                res.add(base + rest);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N017_LetterCombinationsOfAPhoneNumber().letterCombinations("233"));
    }
}
