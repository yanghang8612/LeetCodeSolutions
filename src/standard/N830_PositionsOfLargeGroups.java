package standard;

import java.util.ArrayList;
import java.util.List;

public class N830_PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() < 3) return res;
        S = S + ";";
        char[] c = S.toCharArray();
        for (int i = 1, start = 0; i < c.length; i++) {
            if (c[i] != c[i - 1]) {
                if (i - start >= 3) {
                    res.add(List.of(start, i - 1));
                }
                start = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N830_PositionsOfLargeGroups().largeGroupPositions("aaaabbbbb"));
    }
}
