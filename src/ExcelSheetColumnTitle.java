/**
 * 实际上这个二十六进制是从1开始的，而不是从0开始
 * 同时他能到达传统二十六进制到达不了的26,26->Z
 * 所以采用传统的乘积取整法时，运算每一位时需要将原数减一
 */

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            n -= 1;
            res.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }
}
