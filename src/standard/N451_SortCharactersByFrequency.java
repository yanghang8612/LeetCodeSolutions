package standard;

import java.util.Arrays;

public class N451_SortCharactersByFrequency {

    public String frequencySort(String s) {
        int[] cnt = new int[256];
        Arrays.fill(cnt, 0);
        for (char c : s.toCharArray()) {
            cnt[c] += 1;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        while(true) {
            for (int i = 0; i < 256; i++) {
                max = cnt[i] > cnt[max] ? i : max;
            }
            if (cnt[max] != 0) {
                sb.append(String.valueOf((char) max).repeat(cnt[max]));
                cnt[max] = 0;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new N451_SortCharactersByFrequency().frequencySort("aaAbbb"));
    }
}
