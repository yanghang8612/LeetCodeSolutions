package standard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N554_BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> bricks : wall) {
            int sum = 0;
            for (int i = 0; i < bricks.size() - 1; i++) {
                sum += bricks.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        if (map.isEmpty()) return wall.size();
        int max = Integer.MIN_VALUE;
        for (Integer v : map.values()) {
            max = Math.max(max, v);
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {

    }
}
