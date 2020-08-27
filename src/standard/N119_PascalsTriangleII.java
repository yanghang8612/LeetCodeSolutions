package standard;

import java.util.LinkedList;
import java.util.List;

public class N119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
