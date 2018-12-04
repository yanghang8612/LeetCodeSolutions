/**
 * 这题给颜色排序，颜色一共三种：红、白、蓝，分别用整形的0、1、2来表示
 * 排序是要求相同的颜色相邻，并且顺序按照红、白、蓝的顺序
 * 题意理解完毕之后，那么思路也比较清晰了，在遍历时遇到红色将其扔到前部，遇到蓝色将其扔到尾部，那么中间剩下的就都是白色了
 * 我们遍历到某个元素时，看其值分为三种情况：
 * 1.为0，则需要将其交换到红色部分的尾部，因为红色部分的尾部肯定是白色部分的开头（白色部分长度可以为0），
 *   因此交换过来的元素肯定是1，所以将当前位置的元素置为1，将白色开头的元素置为0即可
 * 2.为1，这种情况下直接将白色部分长度增加1即可
 * 3.为2，这种情况下2交换到蓝色部分的开头部分即可，由于蓝色开头部分尚未遍历到，因此不能像为0的情况那样直接确定所以交换的值
 */

public class SortColors {

    public void sortColors(int[] nums) {
        int whiteStartIndex = 0, whiteEndIndex = 0, blueStartIndex = nums.length - 1;
        while (whiteEndIndex <= blueStartIndex) {
            switch (nums[whiteEndIndex]) {
                case 0:
                    nums[whiteEndIndex++] = 1;
                    nums[whiteStartIndex++] = 0;
                    break;
                case 1:
                    whiteEndIndex++;
                    break;
                case 2:
                    nums[whiteEndIndex] = nums[blueStartIndex];
                    nums[blueStartIndex--] = 2;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{2, 1 ,1, 0, 0, 1, 0, 2};
        //int[] nums = new int[]{2, 1 ,1, 0, 0, 1, 0, 2};
        int[] nums = new int[]{0, 0, 0, 0};
        new SortColors().sortColors(nums);
    }
}
