/**
 * 这个题解法其实也很666，首先承接SingleNumberI的解法，使用异或来处理
 * 在这个题中有两个出现一次的元素，并且这个两个元素并不相同，这个一点很关键
 * 这两个元素不相同的情况下，那么他们俩必定至少有某一位bit一个是0一个是1
 * 那么将其找出来，依据这位比特的下标将整个数组划分为两部分，一部分是该位bit为1的，另一部分是该位bit为0的
 * 那么好了，这两部分显然也是满足除了某个元素出现一次外其他元素均出现两次，这样分开计算两部分的异或就能得到这两个元素
 */

public class SingleNumbetIII {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
