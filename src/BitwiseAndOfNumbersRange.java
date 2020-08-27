import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if ((m & (1 << i)) != 0) {
                int rest = m & (Integer.MAX_VALUE >> 31 - i);
                if (n - m < (1 << i) - rest) {
                    res = res | (1 << i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(100000);
        System.out.println(decimal.sqrt(new MathContext(10, RoundingMode.HALF_UP)));
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(1, Integer.MAX_VALUE));
    }
}
