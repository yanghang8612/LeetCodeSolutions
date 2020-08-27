public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int count = 0;
        for (int num : nums) {
            if (num == 0) count += 1;
            else product *= num;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = count > 1 ? 0 : (int) product;
            } else {
                res[i] = count > 0 ? 0 : (int) product / nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
