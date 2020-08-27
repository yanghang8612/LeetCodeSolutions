package standard;

import java.util.PriorityQueue;
import java.util.Queue;

public class N871_MinimumNumberOfRefuelingStops {

    class Node {
        int maxReach;
        int level;

        public Node(int maxReach, int level) {
            this.maxReach = maxReach;
            this.level = level;
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int maxReach = startFuel, res = 0, i = 0;
        while (maxReach < target) {
            while (i < stations.length && stations[i][0] <= maxReach) {
                queue.offer(stations[i++][1]);
            }
            if (queue.isEmpty()) return -1;
            maxReach += queue.poll();
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
