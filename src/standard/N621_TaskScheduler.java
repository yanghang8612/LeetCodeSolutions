package standard;

import java.util.Arrays;

/**
 * 这题你要明白，为啥需要idle
 * 因为任务不够，中间没法插其他任务满足n
 * 所以需要idle
 */
public class N621_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A'] += 1;
        }
        Arrays.sort(cnt);
        int i = 25;
        while (i >= 0 && cnt[i] == cnt[25]) i -= 1;
        return Math.max(tasks.length, cnt[25] * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {

    }
}
