import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count += 1;
            for (int i = 0; i < numCourses; i++) {
                if (e[cur][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(4, new int[][]{{3,0},{0,1},{1,2},{2,3}}));
    }
}
