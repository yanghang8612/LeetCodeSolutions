import java.util.HashMap;

/**
 * 这题从描述上给人先入玩为主的感觉，你要找到小数部分的循环节，类似于字符串中找重复出现的部分，讲道理这很难为人
 * 实际上，从小数部分的运算方式上可以看出，做除法之后取余乘10继续上述过程，关键在取余，当取余的结果在之前出现过的话，
 * 那么说明，肯定出现了一个完整的循环节
 */

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "NaN";
        StringBuilder res = new StringBuilder();
        res.append(((double) numerator * denominator > 0) ? "" : "-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
    }
}
