package standard;

import java.util.ArrayList;
import java.util.List;

public class N728_SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)) res.add(i);
        }
        return res;
    }

    private boolean check(int n) {
        int tmp = n;
        while (tmp > 0) {
            int d = n % 10;
            if (d == 0) return false;
            if (n % d != 0) return false;
            tmp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
