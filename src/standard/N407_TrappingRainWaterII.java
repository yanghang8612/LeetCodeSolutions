package standard;

import java.util.PriorityQueue;

public class N407_TrappingRainWaterII {

    private class Node implements Comparable<Node> {
        int x, y, h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            return h - o.h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(1);
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            visited[0][i] = true;
            visited[n - 1][i] = true;
            queue.offer(new Node(0, i, heightMap[0][i]));
            queue.offer(new Node(n - 1, i, heightMap[n - 1][i]));
        }

        for (int i = 1; i < n - 1; i++) {
            visited[i][0] = true;
            visited[i][m - 1] = true;
            queue.offer(new Node(i, 0, heightMap[i][0]));
            queue.offer(new Node(i, m - 1, heightMap[i][m - 1]));
        }

        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, node.h - heightMap[x][y]);
                    queue.offer(new Node(x, y, Math.max(node.h, heightMap[x][y])));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
