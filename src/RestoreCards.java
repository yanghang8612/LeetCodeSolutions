import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class RestoreCards {

    public int[] restoreCards(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            if (!q.isEmpty()) q.offer(q.poll());
            q.offer(i);
        }
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[n - i] = q.poll();
        }
        return res;
    }

    public int[] restoreCards_1(int n) {
        Queue<Integer> q = new LinkedList<>();

        return null;
    }

    public static void test() {
        int i = 1/1;
        throw new Error();
        //System.out.println("hehe");
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new RestoreCards().restoreCards(5)));
//        System.out.println(Arrays.toString(new RestoreCards().restoreCards_1(13)));
        try {
            test();
        } catch (Throwable e) {
            System.out.println("yinbi");
            //e.printStackTrace();
        }
        System.out.println("shabi");
    }
}
