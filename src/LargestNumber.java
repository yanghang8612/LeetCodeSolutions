import java.util.Arrays;

/**
 * 好像不是用桶排，但是感觉也可以用，没深挖
 */

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).orElse("");
    }

    public static void main(String[] args) {
        new LargestNumber().largestNumber(null);
        System.out.println("shabi");
    }
}
