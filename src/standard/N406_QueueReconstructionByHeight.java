package standard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N406_QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {

    }
}
