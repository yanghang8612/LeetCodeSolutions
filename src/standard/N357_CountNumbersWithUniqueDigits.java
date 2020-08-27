package standard;

public class N357_CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int i = 0, c = 9; i < n;c *= 9 - i++) {
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N357_CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(4));
    }
}
