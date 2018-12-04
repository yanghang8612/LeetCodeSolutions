/**
 * 首先理解错了，碰到连续的相等元素时，相等的元素分发数量应该是力图使其取1的，因为题中并没有针对相等元素的情况加以限制
 * 那么这样一来，碰到相等的元素可以成为一个分界线，当连续增加的序列中，其中间位置出现了相等元素 1,2,2,3... 这样情况下从
 * 第二个2开始可以分配1个数量，这样将可以从最小的1开始分配，实际上每个独立的相同元素我们都可以看做是一个单独的增序列，只不过他只有1个元素
 * 当碰到连续下降的序列时，这个时候并不知道如何分配，因为暂时无法得知该下降序列的实际长度，毕竟还没有遍历完毕，因此可以做一个记录
 * 记录当前下降序列的元素数量，当再次碰到元素大于等于前元素时，证明下降序列完毕，那么其分配数量应该为1,2...count，使用高斯速算
 * 但是这里有个问题，因为当我们开始统计下降序列时，实际上还有个最大的元素并没有算进来，这个元素算入了前面的增序列中，该元素分配的数量为prev
 * 当count大于等于prev时，这个最大元素必须再增加一些才能使其也大于后续的下降序列的最大分配数量count，注意循环结束后也需要判断count的数值
 * 避免最后的下降序列被漏处理
 */

public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, count = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (count > 0) {
                    total += count * (count + 1) / 2;
                    if (count >= prev) total += count - prev + 1;
                    count = 0;prev = 1;
                }
                total += ratings[i] == ratings[i - 1] ? prev = 1 : ++prev;
            } else {
                count += 1;
            }
        }
        if (count > 0) {
            total += count * (count + 1) / 2;
            if (count >= prev) total += count - prev + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        
    }
}
