public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
