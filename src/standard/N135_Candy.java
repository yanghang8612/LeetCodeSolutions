package standard;

public class N135_Candy {

    public int candy(int[] ratings) {
        int n = ratings.length, total = 1, pre = 1, count = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (count > 0) { // 前面有未处理的递减序列
                    total += count * (count + 1) / 2;
                    if (count >= pre) total += count + 1 - pre;
                    count = 0;
                    pre = 1;
                }
                total += ratings[i] == ratings[i - 1] ? pre = 1 : ++pre;
            } else {
                count += 1;
            }
        }
        if (count > 0) { // 前面有未处理的递减序列
            total += count * (count + 1) / 2;
            if (count >= pre) total += count + 1 - pre;
        }
        return total;
    }

    public static void main(String[] args) {

    }

}
