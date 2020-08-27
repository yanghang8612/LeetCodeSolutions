package standard;

import java.util.ArrayList;
import java.util.List;

public class N118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(List.of(1));
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> curRow = res.get(i);
            List<Integer> nextRow = new ArrayList<>();
            for (int j = 0; j < curRow.size() - 1; j++) {
                nextRow.add(curRow.get(j) + curRow.get(j + 1));
            }
            nextRow.add(1);
            nextRow.add(0, 1);
            res.add(nextRow);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
