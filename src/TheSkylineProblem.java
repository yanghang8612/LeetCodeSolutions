import java.util.*;

public class TheSkylineProblem {

    public List<List<Integer>> getSkylineSB(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> heightHeap = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : b[2] - a[2]);

        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        for(int[] b : buildings) {

            while(!heightHeap.isEmpty() && b[0] > pre[1]) { // totally separated
                int[] curHighest = heightHeap.poll();
                if(curHighest[1] <= pre[1]) continue;
                res.add(Arrays.asList(pre[1], curHighest[2]));
                pre = curHighest;
            }

            if(b[2] > pre[2]) {
                if(b[0] == pre[0]) { // we always make sure pre is the last element in the res
                    // if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    res.remove(res.size() - 1);
                }
                res.add(Arrays.asList(b[0], b[2])); // highest point possibly has a pos in result;
                if(b[1] < pre[1]) {
                    heightHeap.offer(pre); //previous covers more length, need to add into heightheap for furture.
                }
                pre = b;
            }
            else if(b[1] > pre[1]) {
                if(b[2] == pre[2]) {
                    pre[1] = b[1];
                }
                else {
                    heightHeap.offer(b);
                }
            }
        }
        while(!heightHeap.isEmpty()) {
            int[] cur = heightHeap.poll();
            if(cur[1] <= pre[1]) continue;
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }

        if(pre[2] > 0) {
            res.add(Arrays.asList(pre[1], 0));
        }
        return res;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new Point(building[0], -building[2]));
            points.add(new Point(building[1], building[2]));
        }
        points.sort((a, b) -> a.x == b.x ? a.y - b.y : a.x - b.x);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        List<List<Integer>> res = new ArrayList<>();
        for (Point p : points) {
            if (p.y < 0) {
                queue.offer(-p.y);
            } else {
                queue.remove(p.y);
            }
            int y = queue.isEmpty() ? 0 : queue.peek();
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != y) {
                res.add(toList(p.x, y));
            }
        }
        return res;
    }

    private List<Integer> toList(int x, int y) {
        List<Integer> list = new ArrayList<>();
        list.add(x);list.add(y);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new TheSkylineProblem().getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}}));
    }
}
