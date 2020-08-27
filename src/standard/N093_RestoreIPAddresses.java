package standard;

import java.util.ArrayList;
import java.util.List;

public class N093_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        return covert(res, s, 4);
    }

    public List<String> covert(List<String> addr, String s, int n) {
        List<String> res = new ArrayList<>();
        if (s.length() > n * 3 || s.length() < n) return res;
        for (int i = 1; i <= 3; i++) {
            if (s.charAt(0) == '0') {
            }
            int num = Integer.parseInt(s.substring(0, i));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
