package standard;

/**
 * 首先这题采用o(n)方式遍历检查当前元素是否满足条件要超时,因为用例最多达到10^9
 * 看了提示之后用动规,好像也没啥思路
 * 应该从二进制位上着眼,动规的目标在各二进制位上
 * 假设我们要找小于111……1的所有解,那么范围应该从000……0到111……1
 * 分成3部分,其中一部分为小于100……0的部分,它的范围从000……0到011……1
 * 另一部分为大于100……0的部分,从100……0到101……1
 * 最后一部分为大于110……0,很显然他不可能是解的一部分,因为他开头就有2个连续的1
 * 那么我们看前两部分的结构,可以察觉到他们的范围可以省略为从00……0到11……1和从0……0到1……1
 * 如果定义f(k)为长度为k的二进制数,他表示了满足题意的范围内的解数量,那么有f(k) = f(k - 1) + f(k - 2)
 * 斐波那契数列
 * 然后根据实际num的各位的数值,从高位开始往下滤就好了
 */
public class N600_NonNegativeIntegersWithoutConsecutiveOnes {

    public int findIntegers(int num) {
        int[] f = new int[32];
        f[1] = 2; f[0] = 1;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        String s = Integer.toBinaryString(num);
        int res = 0, n = s.length();
        for (int i = 0, pre = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                res += f[n - i - 1];
                if (pre == 1) return res;
                pre = 1;
            } else {
                pre = 0;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6));
    }
}
