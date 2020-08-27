import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int cost = 0;
        for (int[] c : courses) {
            cost += c[0];
            pq.add(c[0]);
            if (cost > c[1]) {
                cost -= pq.poll();
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {

    }
}
