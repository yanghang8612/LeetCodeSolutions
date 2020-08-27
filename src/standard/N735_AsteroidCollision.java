package standard;

import java.util.*;

public class N735_AsteroidCollision {

    public int[] asteroidCollision(int[] a) {
        Deque<Integer> s = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0) {
                s.add(a[i]);
            } else if (s.getLast() <= -a[i]) {
                if (s.pollLast() < -a[i]) {
                    i -= 1;
                }
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
    }
}
