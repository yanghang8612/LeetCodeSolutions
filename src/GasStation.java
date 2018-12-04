/**
 * 考虑加减法的结合性
 * 第一点需要考虑证明gas总和加起来大于等于cost总和，这种情况下必有解，否则无解
 * 第二点需要考虑证明唯一解的起始位置应该在从0下标开始的left总计数组的最小值的下一个下标
 * 实际上，只要满足第一点，任何一个位置开始做left的总计计算时，最后都会以相同的统计值结束，这就是加减法的结合性
 */

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, minIndex = 0;
        gas[0] -= cost[0];
        for (int i = 1; i < n; i++) {
            gas[i] += gas[i - 1] - cost[i];
            minIndex = gas[i] < gas[minIndex] ? i : minIndex;
        }
        if (gas[n - 1] >= 0) return Math.floorMod(minIndex + 1, n);
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
