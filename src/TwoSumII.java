import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0, j = -1; i < numbers.length && j == -1; i++) {
            j = findX(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                res[0] = i + 1;
                res[1] = j + 1;
            }
        }
        return res;
    }

    private int findX(int[] numbers, int low, int high, int target) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == target) return mid;
            else if (numbers[mid] > target) high = mid;
            else low = mid + 1;
        }
        return numbers[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));
    }
}
