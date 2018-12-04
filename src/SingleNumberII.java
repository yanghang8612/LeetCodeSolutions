public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;
        for (int num : nums) {
            x2 ^= num & x1;
            x1 ^= num;
            mask = ~ (x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {

    }
}
