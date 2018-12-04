import java.util.*;

/**
 * 实际是四进制，可以使用int型的hash来保存遍历结果，可能会快一些
 */

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 11) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String part = s.substring(i, i + 10);
            if (!map.containsKey(part)) {
                map.put(part, 1);
            } else if (map.get(part) == 1) {
                res.add(part);
                map.put(part, 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
