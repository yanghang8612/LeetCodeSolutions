import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] e = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            e[p[1]][p[0]] = 1;
            indegree[p[0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count++] = cur;
            for (int i = 0; i < numCourses; i++) {
                if (e[cur][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses ? res : new int[numCourses];
    }

    public static void main(String[] args) {

    }
}
